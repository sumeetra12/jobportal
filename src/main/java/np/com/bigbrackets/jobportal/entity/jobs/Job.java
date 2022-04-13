package np.com.bigbrackets.jobportal.entity.jobs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import np.com.bigbrackets.jobportal.entity.employer.Employer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String category;
    @NotNull
    private String description;
    private Long salary;
    private int numOfVacancy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date timeDuration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Job(int id, String title, String category, String description, Long salary, int numOfVacancy, Date timeDuration){
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.salary = salary;
        this.numOfVacancy = numOfVacancy;
        this.timeDuration = timeDuration;
    }

    public Job(){
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getNumOfVacancy() {
        return numOfVacancy;
    }

    public void setNumOfVacancy(int numOfVacancy) {
        this.numOfVacancy = numOfVacancy;
    }

    public Date getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(Date timeDuration) {
        this.timeDuration = timeDuration;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
