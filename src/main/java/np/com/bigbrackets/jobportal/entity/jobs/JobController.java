package np.com.bigbrackets.jobportal.entity.jobs;

import np.com.bigbrackets.jobportal.entity.users.Role;
import np.com.bigbrackets.jobportal.entity.users.User;
import np.com.bigbrackets.jobportal.entity.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {


    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobMapping jobMapping;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<JobDto> getJobs() {
        List<Job> job = this.jobService.getJobs();
        return jobMapping.convertJobToJobDto(job);
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<JobDto> getJob(@PathVariable() int jobId) {
        Optional<Job> oJob = this.jobService.getJob(jobId);
        if (oJob.isPresent()) {
            return ResponseEntity.ok(jobMapping.convertJobToJobDto(oJob.get()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/jobs")
   // @PreAuthorize("hasRole(EMPLOYER)")
    public JobDto addJob(@RequestBody Job job) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User u = userService.getUserByEmail(userDetails.getUsername());
        if (!u.getRole().equals(Role.ROLE_EMPLOYER)) {
            throw new RuntimeException("You cannot create job");
        }

        job.setEmployer(u.getEmployer());
        job = this.jobService.addJob(job);

        JobDto jobDto = jobMapping.convertJobToJobDto(job);
        return jobDto;

    }

    @PutMapping("/jobs/{jobId}")
   // @PreAuthorize("hasRole(EMPLOYER)")
    public ResponseEntity<Job> updateJob(@PathVariable() int jobId, @RequestBody Job job) {
        Optional<Job> oJob = this.jobService.getJob(jobId);
        if (oJob.isPresent()) {
            this.jobService.updateJob(job);
            return ResponseEntity.ok(oJob.get());
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/jobs/{jobId}")
//    @PreAuthorize("hasRole(EMPLOYER)")
    public ResponseEntity<Void> deleteJob(@PathVariable() int jobId) {
        Optional<Job> oJob = this.jobService.getJob(jobId);
        if (oJob.isPresent()) {
            this.jobService.deleteJob(jobId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}
