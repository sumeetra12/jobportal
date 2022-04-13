package np.com.bigbrackets.jobportal.entity.employer;

import np.com.bigbrackets.jobportal.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<Employer> getEmployers() {
        return employerRepository.findAll();
    }

    @Override
    public Optional<Employer> getEmployer(int employerId) {
        return employerRepository.findById(employerId);
        //.orElseThrow(() -> new RuntimeException("Employee with id " + employerId + " not found."));
    }

    @Override
    public Employer addEmployer(Employer employer) {
        employerRepository.save(employer);
        return employer;
    }

    @Override
    public Employer updateEmployer(Employer employer) {
        employerRepository.save(employer);
        return employer;
    }

    @Override
    public Employer deleteEmployer(int employerId) {
        Employer entity = employerRepository.getById(employerId);
        employerRepository.delete(entity);
        return null;
    }

    @Override
    public Employer getEmployerByUser(User user) {
        return employerRepository.findByUser(user);
    }
}
