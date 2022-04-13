package np.com.bigbrackets.jobportal.entity.jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer>, PagingAndSortingRepository<Job, Integer> {
    List<Job> findAllByTimeDurationAfter(Date now);
}
