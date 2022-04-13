package np.com.bigbrackets.jobportal.entity.users;

public enum Role {
    ROLE_EMPLOYER("ROLE_EMPLOYER"),
    ROLE_APPLICANT("ROLE_APPLICANT"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
