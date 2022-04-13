package np.com.bigbrackets.jobportal.resumeupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex){
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored");
        }
    }

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(System.currentTimeMillis() + "-" +file.getOriginalFilename());

        try {
            if (fileName.contains("..")){
                throw new RuntimeException("Sorry!! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex){
            throw new RuntimeException("could not store file. Please try again");
        }
    }

    public Resource loadFileResource(String fileName){
        try{
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()){
                return resource;
            }else{
                throw new RuntimeException("File not found");
            }
        } catch (MalformedURLException ex){
            throw new RuntimeException("file not found");
        }
    }
}
