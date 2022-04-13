package np.com.bigbrackets.jobportal.entity.users;

public class ProfileDto {

    private int userId;
    private String name;
    private String email;
    private Long contactNum;
    private String address;
    private String companyName;
    private String companyAddress;
    private String companyRegistrationNumber;
    private String resume;
    private String role;

    public ProfileDto(){

    }

    public ProfileDto(int userId, String name, String email, Long contactNum, String address, String companyName, String companyAddress, String companyRegistrationNumber, String resume, String role){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNum = contactNum;
        this.address = address;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.resume  = resume;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Long getContactNum() {
        return contactNum;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
