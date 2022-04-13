package np.com.bigbrackets.jobportal.entity.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAllByTimeDurationAfter(new Date());
    }

    @Override
    public Optional<Job> getJob(int jobId) {
        return jobRepository.findById(jobId);
        //.orElseThrow(() -> new RuntimeException("Job with id " + jobId + " not found."));
    }

    @Override
    public Job addJob(Job job) {
        jobRepository.save(job);
        return job;
    }

    @Override
    public Job updateJob(Job job) {
        jobRepository.save(job);
        return job;
    }

    @Override
    public Job deleteJob(int jobId) {
        Job entity = jobRepository.getById(jobId);
        jobRepository.delete(entity);
        return null;
    }


}
