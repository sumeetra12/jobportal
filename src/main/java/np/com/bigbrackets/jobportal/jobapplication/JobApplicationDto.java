package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.ApplicantDto;
import np.com.bigbrackets.jobportal.entity.jobs.JobDto;


public class JobApplicationDto {
    private ApplicantDto applicant;

    private JobDto job;

    private JobStatus jobStatus;

    public ApplicantDto getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantDto applicant) {
        this.applicant = applicant;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
}
