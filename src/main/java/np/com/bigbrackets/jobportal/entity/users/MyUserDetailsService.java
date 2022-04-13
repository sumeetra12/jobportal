package np.com.bigbrackets.jobportal.entity.users;

import np.com.bigbrackets.jobportal.config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //fetching user from db
        User user = userRepository.getUserByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not found user!!");
        }

        return new CustomUserDetails(user);
    }
}
