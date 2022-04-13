package np.com.bigbrackets.jobportal.jobapplication;

public class ChangeJobApplicationStatusDto {
    private JobStatus jobStatus;

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
}
