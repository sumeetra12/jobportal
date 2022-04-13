package np.com.bigbrackets.jobportal.auth.models;

public class AuthenticationResponse {

    private final String jwtToken;
    private UserDto userDto;

    public AuthenticationResponse(String jwtToken, UserDto userDto){
        this.jwtToken = jwtToken;
        this.userDto = userDto;
    }

    public String getJwtToken(){
        return jwtToken;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
