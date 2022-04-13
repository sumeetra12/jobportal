package np.com.bigbrackets.jobportal.jobapplication;

public class JobApplicationResponse {

    private String message;

    public JobApplicationResponse(){

    }

    public JobApplicationResponse(String message){
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
