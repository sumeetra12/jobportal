package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.employer.Employer;

import java.util.List;

public interface JobApplicationService {
    JobApplication applyJob(JobApplication jobApplication);
    JobApplication save(JobApplication jobApplication);
    List<JobApplication> getUsersApplication(Applicant applicant);
    List<JobApplication> getCompanyApplication(Employer employer);
    JobApplication getJobApplicationByJobIdAndApplicationId(int jobId, int applicantId);
}
