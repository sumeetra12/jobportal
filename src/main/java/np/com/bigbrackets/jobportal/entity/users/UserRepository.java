package np.com.bigbrackets.jobportal.entity.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
    User getUserByEmail(@Param("email") String email);
}
