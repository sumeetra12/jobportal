package np.com.bigbrackets.jobportal.auth.models;

public class SignUpResponse {

    private String message ;

    public SignUpResponse(){

    }

    public SignUpResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
