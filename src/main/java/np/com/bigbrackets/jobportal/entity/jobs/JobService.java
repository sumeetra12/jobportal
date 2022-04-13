package np.com.bigbrackets.jobportal.entity.jobs;

import java.util.List;
import java.util.Optional;


public interface JobService {

    List<Job> getJobs();

    Optional<Job> getJob(int jobId);

    Job addJob(Job job);

    Job updateJob(Job job);

    Job deleteJob(int jobId);
}
