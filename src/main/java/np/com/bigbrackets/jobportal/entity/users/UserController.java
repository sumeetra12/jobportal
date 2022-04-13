package np.com.bigbrackets.jobportal.entity.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapping userMapping;

    @GetMapping("/profiles")
    public ProfileDto getUserProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        ProfileDto profileDto = userMapping.convertUserToProfileDto(userService.getUserByEmail(userDetails.getUsername()));
     //   if(user == null) throw new RuntimeException("User not found");
        return profileDto;

    }

}
