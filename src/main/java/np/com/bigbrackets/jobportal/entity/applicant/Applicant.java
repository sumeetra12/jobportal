package np.com.bigbrackets.jobportal.entity.applicant;

import com.sun.istack.NotNull;
import np.com.bigbrackets.jobportal.entity.users.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "applicants")
public class Applicant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String resume;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Applicant(){
        super();
    }

    public Applicant(int id, String resume){
        super();
        this.id = id;
        this.resume = resume;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
