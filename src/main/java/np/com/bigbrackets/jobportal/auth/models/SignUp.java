package np.com.bigbrackets.jobportal.auth.models;

public class SignUp {

    // common
    private String name;
    private String email;
    private String password;
    private String address;
    private Long contactNum;

    // employer
    private String companyName;
    private String companyAddress;
    private String companyRegistrationNumber;

    private String role;


    public SignUp(){

    }

    public SignUp(String name, String email, String password, String address, Long contactNum, String companyName, String companyAddress, String companyRegistrationNumber, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNum = contactNum;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNum() {
        return contactNum;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
