package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.employer.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
    List<JobApplication> findAllByApplicant(Applicant applicant);
    List<JobApplication> findAllByJob_Employer(Employer employer);
    JobApplication findByJob_IdAndAndApplicant_Id(int jobId, int applicantId);
}
