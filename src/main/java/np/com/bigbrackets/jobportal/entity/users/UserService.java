package np.com.bigbrackets.jobportal.entity.users;

public interface UserService {
    User addUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
}
