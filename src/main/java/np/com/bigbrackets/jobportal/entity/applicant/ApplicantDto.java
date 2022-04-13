package np.com.bigbrackets.jobportal.entity.applicant;

public class ApplicantDto {

    private int id;
    private String email;
    private String name;
    private String address;
    private String contactNum;
    private String resume;

    public ApplicantDto(){

    }

    public ApplicantDto(int id, String email, String name, String address, String contactNum, String resume){
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
        this.resume = resume;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
