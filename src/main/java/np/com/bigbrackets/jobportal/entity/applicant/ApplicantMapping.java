package np.com.bigbrackets.jobportal.entity.applicant;

import np.com.bigbrackets.jobportal.auth.models.SignUp;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapping {

    public Applicant convertSignUpToApplicant(SignUp signUp) {

        Applicant a = new Applicant();


        return a;
    }

    public ApplicantDto convertApplicantToApplicantDto(Applicant applicant) {
        ApplicantDto a = new ApplicantDto();

        a.setId(applicant.getId());
        a.setEmail(applicant.getUser().getEmail());
        a.setName(applicant.getUser().getName());
        a.setAddress(applicant.getUser().getAddress());
        a.setContactNum(applicant.getUser().getContactNum().toString());
        a.setResume(applicant.getResume());

        return a;
    }


}
