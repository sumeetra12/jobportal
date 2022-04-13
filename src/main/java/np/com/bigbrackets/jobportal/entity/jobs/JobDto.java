package np.com.bigbrackets.jobportal.entity.jobs;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobDto {

    private int id;
    private String title;
    private String category;
    private String description;
    private Long salary;
    private int numOfVacancy;
    private Date timeDuration;
    private EmployerDtoForJob employer;

    public JobDto(){

    }

    public JobDto(int id, String title, String category, String description, Long salary, int numOfVacancy, Date timeDuration){
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.salary = salary;
        this.numOfVacancy = numOfVacancy;
        this.timeDuration = timeDuration;
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

    public EmployerDtoForJob getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDtoForJob employer) {
        this.employer = employer;
    }
}
