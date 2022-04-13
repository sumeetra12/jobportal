package np.com.bigbrackets.jobportal.entity.applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicantMapping applicantMapping;

    public ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @GetMapping("/applicants")
    public List<Applicant> getApplicants(){
        return this.applicantService.getApplicants();
    }

    @GetMapping("/applicants/{applicantId}")
    public ResponseEntity<Applicant> getApplicant(@PathVariable() int applicantId){
        Optional<Applicant> oApplicant =this.applicantService.getApplicant(applicantId);
        if(oApplicant.isPresent()){
            return ResponseEntity.ok(oApplicant.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/applicants")
    public Applicant addApplicant(@RequestBody Applicant applicant){
        //ApplicantDto a = applicantMapping.convertApplicantToApplicantDto(applicant);

        return this.applicantService.addApplicant(applicant);
    }

    @PutMapping("/applicants/{applicantI}d")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable() int applicantId, @RequestBody Applicant applicant){
         Optional<Applicant> oApplicant = this.applicantService.getApplicant(applicantId);
                 if(oApplicant.isPresent()){
                     this.applicantService.updateApplicant(applicant);
                     return ResponseEntity.ok(oApplicant.get());
                 }else{
                     return ResponseEntity.badRequest().build();
                 }

    }

    @DeleteMapping("/applicants/{applicantId}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable() int applicantId){
        Optional<Applicant> oApplicant = this.applicantService.getApplicant(applicantId);
        if(oApplicant.isPresent()){
            this.applicantService.deleteApplicant(applicantId);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

}
