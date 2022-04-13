package np.com.bigbrackets.jobportal.entity.employer;

import com.sun.istack.NotNull;
import np.com.bigbrackets.jobportal.entity.jobs.Job;
import np.com.bigbrackets.jobportal.entity.users.User;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Table(name="employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String companyName;
    @NotNull
    private String companyAddress;
    @NotNull
    private String companyRegistrationDetails;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "employer")
    private List<Job> job;

    public Employer(int id, String companyName, String companyAddress, String companyRegistrationDetails) {
        super();
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyRegistrationDetails = companyRegistrationDetails;


    }

    public Employer() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCompanyRegistrationDetails() {
        return companyRegistrationDetails;
    }

    public void setCompanyRegistrationDetails(String companyRegistrationDetails) {
        this.companyRegistrationDetails = companyRegistrationDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }
}
