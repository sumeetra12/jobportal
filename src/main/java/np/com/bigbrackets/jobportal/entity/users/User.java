package np.com.bigbrackets.jobportal.entity.users;

import com.sun.istack.NotNull;
import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.employer.Employer;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String address;
    private Long contactNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Applicant applicant;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Employer employer;

    public User(){
    }

    public User(int id, String email, String password, String name, String address, Long contactNum){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Long getContactNum() {
        return contactNum;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
