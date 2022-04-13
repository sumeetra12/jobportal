package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.applicant.ApplicantService;
import np.com.bigbrackets.jobportal.entity.employer.Employer;
import np.com.bigbrackets.jobportal.entity.employer.EmployerService;
import np.com.bigbrackets.jobportal.entity.jobs.Job;
import np.com.bigbrackets.jobportal.entity.jobs.JobService;
import np.com.bigbrackets.jobportal.entity.users.Role;
import np.com.bigbrackets.jobportal.entity.users.User;
import np.com.bigbrackets.jobportal.entity.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobApplicationMapper jobApplicationMapper;

    @GetMapping("/applied-jobs/{jobId}")
    public JobApplicationResponse applyJob(@PathVariable() int jobId){

        Job job = jobService.getJob(jobId).orElseThrow(() -> new RuntimeException("Job not found."));
        if(job.getTimeDuration().before(new Date())) throw new RuntimeException("Job expired");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        if(user == null) throw new RuntimeException("User not found");
        if(!user.getRole().equals(Role.ROLE_APPLICANT)) throw new RuntimeException("User not allowed to apply for jobs.");

        Applicant applicant = applicantService.getApplicantByUser(user);

        JobApplication jobApplication  = new JobApplication();
        jobApplication.setApplicant(applicant);
        jobApplication.setJob(job);
        jobApplication.setJobStatus(JobStatus.PENDING);

        jobApplicationService.applyJob(jobApplication);

        JobApplicationResponse jobApplicationResponse = new JobApplicationResponse();
        jobApplicationResponse.setMessage("Job Applied Successfully");

        return jobApplicationResponse;
    }

    @GetMapping("/applied-jobs/users")
    public List<JobApplicationDto> getUsersAppliedJob() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        if(user == null) throw new RuntimeException("User not found");
        if(!user.getRole().equals(Role.ROLE_APPLICANT)) throw new RuntimeException("User cannot view this job");

        Applicant applicant = applicantService.getApplicantByUser(user);
        List<JobApplication> applicationList = jobApplicationService.getUsersApplication(applicant);
        return jobApplicationMapper.convertToDto(applicationList);
    }

    @GetMapping("/applied-jobs/users/job/{jobId}")
    public JobApplicationResponse getUserApplicationForJob(@PathVariable int jobId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        if(user == null) throw new RuntimeException("User not found");
        if(!user.getRole().equals(Role.ROLE_APPLICANT)) throw new RuntimeException("User cannot view this job");

        Applicant applicant = applicantService.getApplicantByUser(user);
        JobApplication applicationList = jobApplicationService.getJobApplicationByJobIdAndApplicationId(jobId, applicant.getId());
        if(applicationList == null) {
            return new JobApplicationResponse("failure");
        } else {
            return new JobApplicationResponse("success");
        }
    }

    @GetMapping("/applied-jobs/company")
    public List<JobApplicationDto> getCompanyAppliedJob() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByEmail(userDetails.getUsername());
        if(user == null) throw new RuntimeException("User not found");
        if(!user.getRole().equals(Role.ROLE_EMPLOYER)) throw new RuntimeException("User cannot view this job");

        Employer employer = employerService.getEmployerByUser(user);
        List<JobApplication> applicationList = jobApplicationService.getCompanyApplication(employer);
        return jobApplicationMapper.convertToDto(applicationList);
    }

    @PatchMapping("/applied-jobs/jobs/{jobId}/applicant/{applicationId}")
    public JobApplicationResponse changeStatus(@PathVariable int jobId, @PathVariable int applicationId, @RequestBody ChangeJobApplicationStatusDto dto) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationByJobIdAndApplicationId(jobId, applicationId);
        jobApplication.setJobStatus(dto.getJobStatus());
        jobApplicationService.save(jobApplication);
        return new JobApplicationResponse("Successfully Change of application status.");
    }
}
