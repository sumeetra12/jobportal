package np.com.bigbrackets.jobportal.entity.jobs;

import np.com.bigbrackets.jobportal.entity.employer.Employer;
import np.com.bigbrackets.jobportal.entity.employer.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobMapping {


    public JobDto convertJobToJobDto(Job job){

        JobDto j = new JobDto();

        j.setId(job.getId());
        j.setTitle(job.getTitle());
        j.setCategory(job.getCategory());
        j.setDescription(job.getDescription());
        j.setSalary(job.getSalary());
        j.setNumOfVacancy(job.getNumOfVacancy());
        j.setTimeDuration(job.getTimeDuration());
        j.setEmployer(new EmployerDtoForJob(job.getEmployer()));
        return j;
    }

    public List<JobDto> convertJobToJobDto(List<Job> jobList){

        List<JobDto> jdList = new ArrayList<>();

        for(Job j: jobList) {
            jdList.add(convertJobToJobDto(j));
        }

        return jdList;
    }

    public EmployerDtoForJob convertEmployerDtoForJobs(Employer employer){
        EmployerDtoForJob e = new EmployerDtoForJob();

        e.setId(employer.getId());
        e.setName(employer.getUser().getName());
        e.setEmail(employer.getUser().getEmail());
        e.setCompanyName(employer.getCompanyName());
        e.setCompanyAddress(employer.getCompanyAddress());
        e.setCompanyRegistrationNumber(employer.getCompanyRegistrationDetails());

        return e;

    }
}
