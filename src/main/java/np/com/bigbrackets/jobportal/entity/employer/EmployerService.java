package np.com.bigbrackets.jobportal.entity.employer;

import np.com.bigbrackets.jobportal.entity.users.User;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    List<Employer> getEmployers();

    Optional<Employer> getEmployer(int employerId);

    Employer addEmployer(Employer employer);

    Employer updateEmployer(Employer employer);

    Employer deleteEmployer(int employerId);

    Employer getEmployerByUser(User user);
}
