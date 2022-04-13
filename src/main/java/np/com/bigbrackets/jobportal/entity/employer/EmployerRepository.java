package np.com.bigbrackets.jobportal.entity.employer;

import np.com.bigbrackets.jobportal.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer>, CrudRepository<Employer, Integer> {
    Employer findByUser(User user);
}
