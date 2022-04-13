package np.com.bigbrackets.jobportal.entity.applicant;

import np.com.bigbrackets.jobportal.entity.users.User;

import java.util.List;
import java.util.Optional;

public interface ApplicantService {
    List<Applicant> getApplicants();

    Optional<Applicant> getApplicant(int applicantId);

    Applicant addApplicant(Applicant applicant);

    Applicant updateApplicant(Applicant applicant);

    Applicant deleteApplicant(int applicantId);

    Applicant getApplicantByUser(User user);
}
