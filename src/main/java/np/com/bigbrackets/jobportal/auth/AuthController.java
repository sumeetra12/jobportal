package np.com.bigbrackets.jobportal.auth;

import np.com.bigbrackets.jobportal.auth.models.*;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.applicant.ApplicantMapping;
import np.com.bigbrackets.jobportal.entity.applicant.ApplicantService;
import np.com.bigbrackets.jobportal.entity.employer.Employer;
import np.com.bigbrackets.jobportal.entity.employer.EmployerMapping;
import np.com.bigbrackets.jobportal.entity.employer.EmployerService;
import np.com.bigbrackets.jobportal.entity.users.User;
import np.com.bigbrackets.jobportal.entity.users.UserMapping;
import np.com.bigbrackets.jobportal.entity.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserMapping userMapping;

    @Autowired
    private EmployerMapping employerMapping;

    @Autowired
    private ApplicantMapping applicantMapping;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
            System.out.println("here");
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());


        User u = userService.getUserByEmail(userDetails.getUsername());
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        UserDto userDto = userMapping.convertUserToUserDto(u);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken, userDto));
    }

    @PostMapping("/signup")
    public SignUpResponse addSignUp(@RequestBody SignUp signUp){
        if(signUp.getRole() == null || (!signUp.getRole().equals("employer") && !signUp.getRole().equals("applicant"))) {
            throw new RuntimeException("The given role is not allowed.");
        }
        User u = userMapping.convertSignUpToUser(signUp) ;
        User user = this.userService.addUser(u);

        if(signUp.getRole().equals("employer")) {
            Employer e = employerMapping.convertSignUpToEmployer(signUp);
            e.setUser(user);
            Employer employer = this.employerService.addEmployer(e);
            employerService.addEmployer(employer);
        }else{
            Applicant a = applicantMapping.convertSignUpToApplicant(signUp);
            a.setUser(user);
            Applicant applicant = this.applicantService.addApplicant(a);
            applicantService.addApplicant(applicant);
        }

        SignUpResponse signUpResponse = new SignUpResponse();
        signUpResponse.setMessage("Signup Successfull!!");
        return signUpResponse;
    }


}
