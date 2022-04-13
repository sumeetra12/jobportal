package np.com.bigbrackets.jobportal.entity.applicant;

import np.com.bigbrackets.jobportal.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>, CrudRepository<Applicant, Integer> {

    Applicant findByUser(User user);

}
