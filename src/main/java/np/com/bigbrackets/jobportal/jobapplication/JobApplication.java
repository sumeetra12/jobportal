package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.Applicant;
import np.com.bigbrackets.jobportal.entity.jobs.Job;

import javax.persistence.*;

@Entity
@IdClass(ApplicantJobId.class)
public class JobApplication {
    @Id
    @ManyToOne
    private Applicant applicant;

    @Id
    @ManyToOne
    private Job job;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    public JobApplication() {
    }

    public JobApplication(Applicant applicant, Job job, JobStatus jobStatus) {
        this.applicant = applicant;
        this.job = job;
        this.jobStatus = jobStatus;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
}
