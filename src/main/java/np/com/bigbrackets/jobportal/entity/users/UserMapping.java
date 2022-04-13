package np.com.bigbrackets.jobportal.entity.users;

import np.com.bigbrackets.jobportal.auth.models.SignUp;
import np.com.bigbrackets.jobportal.auth.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User convertSignUpToUser(SignUp signUp){
        User u = new User();
        u.setName(signUp.getName());
        u.setEmail(signUp.getEmail());
        u.setPassword(passwordEncoder.encode(signUp.getPassword()));
        u.setAddress(signUp.getAddress());
        u.setContactNum(signUp.getContactNum());
        u.setRole(signUp.getRole().equals("employer") ? Role.ROLE_EMPLOYER : Role.ROLE_APPLICANT);
        return u;

    }

    public UserDto convertUserToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().getValue());
        return userDto;
    }

    public ProfileDto convertUserToProfileDto(User user) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setUserId(user.getId());
        profileDto.setName(user.getName());
        profileDto.setEmail(user.getEmail());
        profileDto.setAddress(user.getAddress());
        profileDto.setContactNum(user.getContactNum());
        profileDto.setRole(user.getRole().getValue());
        if(user.getEmployer() != null) {
            profileDto.setCompanyName(user.getEmployer().getCompanyName());
            profileDto.setCompanyAddress(user.getEmployer().getCompanyAddress());
            profileDto.setCompanyRegistrationNumber(user.getEmployer().getCompanyRegistrationDetails());
        }
        if(user.getApplicant() !=null) {
            profileDto.setResume(user.getApplicant().getResume());
        }
        return profileDto;
    }
}
