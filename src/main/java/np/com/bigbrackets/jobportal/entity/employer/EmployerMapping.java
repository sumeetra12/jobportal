package np.com.bigbrackets.jobportal.entity.employer;

import np.com.bigbrackets.jobportal.auth.models.SignUp;
import org.springframework.stereotype.Component;

@Component
public class EmployerMapping {
    public Employer convertSignUpToEmployer(SignUp signUp){

        Employer e = new Employer();

        e.setCompanyName(signUp.getCompanyName());
        e.setCompanyAddress(signUp.getCompanyAddress());
        e.setCompanyRegistrationDetails(signUp.getCompanyRegistrationNumber());

        return e;


    }
}
