package np.com.bigbrackets.jobportal.resumeupload;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.applicant.ApplicantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/upload")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
        String fileName = fileStorageService.storeFile(file);

        return new UploadFileResponse(fileName, file.getContentType(), file.getSize());
    }

    @GetMapping("/download/{applicantId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int applicantId, HttpServletRequest request) {

        Applicant applicant = applicantService.getApplicant(applicantId).orElseThrow(() -> new RuntimeException("Applicant Not found."));
        Resource resource = fileStorageService.loadFileResource(applicant.getResume());

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        } catch (IOException e) {
            logger.info("Could not determine file type.");
        }
        if(contentType == null){
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }
}
