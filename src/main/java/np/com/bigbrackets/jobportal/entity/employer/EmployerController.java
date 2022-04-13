package np.com.bigbrackets.jobportal.entity.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @GetMapping("/employers")
    public List<Employer> getEmployers(){
        return this.employerService.getEmployers();
    }

    @GetMapping("/employers/{employerId}")
    public ResponseEntity<Employer> getEmployer(@PathVariable() int employerId){
        Optional<Employer> oEmployer =this.employerService.getEmployer(employerId);
        if(oEmployer.isPresent()){
            return ResponseEntity.ok(oEmployer.get());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/employers")
    public Employer addEmployer(@RequestBody Employer employer){
        return this.employerService.addEmployer(employer);
    }

    @PutMapping("/employers/{employerId}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable() int employerId, @RequestBody Employer employer){
        Optional<Employer> oEmployer = this.employerService.getEmployer(employerId);
        if(oEmployer.isPresent()){
            this.employerService.updateEmployer(employer);
            return ResponseEntity.ok(oEmployer.get());
        }else{
            return ResponseEntity.badRequest().build();
        }


    }

    @DeleteMapping("/employers/{employerId}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable() int employerId){
        Optional<Employer> oEmployer =this.employerService.getEmployer(employerId);
        if(oEmployer.isPresent()){
            this.employerService.deleteEmployer(employerId);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }

    }

}
