package np.com.bigbrackets.jobportal.entity.employer;

import org.springframework.stereotype.Component;

@Component
public class EmployerDto {

    private int id;
    private String email;
    private String name;
    private String address;
    private String contactNum;
    private String companyName;
    private String companyAddress;
    private String companyRegistrationNumber;

    public EmployerDto(){

    }

    public EmployerDto(int id, String email, String name, String address,String contactNum,String companyName, String companyAddress, String companyRegistrationNumber){
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
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
}
