package np.com.bigbrackets.jobportal.jobapplication;

public enum JobStatus {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private String value;

    JobStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
