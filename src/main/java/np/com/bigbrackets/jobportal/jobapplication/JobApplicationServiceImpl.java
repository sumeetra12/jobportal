package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.employer.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Override
    public JobApplication applyJob(JobApplication jobId) {
        return jobApplicationRepository.save(jobId);

    }

    @Override
    public JobApplication save(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplication> getUsersApplication(Applicant applicant) {
        return jobApplicationRepository.findAllByApplicant(applicant);
    }

    @Override
    public List<JobApplication> getCompanyApplication(Employer employer) {
        return jobApplicationRepository.findAllByJob_Employer(employer);
    }

    @Override
    public JobApplication getJobApplicationByJobIdAndApplicationId(int jobId, int applicantId) {
        return jobApplicationRepository.findByJob_IdAndAndApplicant_Id(jobId, applicantId);
    }

}
