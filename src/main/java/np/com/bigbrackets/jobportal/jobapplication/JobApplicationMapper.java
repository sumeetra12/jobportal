package np.com.bigbrackets.jobportal.jobapplication;

import np.com.bigbrackets.jobportal.entity.applicant.ApplicantMapping;
import np.com.bigbrackets.jobportal.entity.jobs.JobMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobApplicationMapper {

    @Autowired
    private JobMapping jobMapping;

    @Autowired
    private ApplicantMapping applicantMapping;

    public JobApplicationDto convertToDto(JobApplication ja) {
        JobApplicationDto dto = new JobApplicationDto();
        dto.setApplicant(applicantMapping.convertApplicantToApplicantDto(ja.getApplicant()));
        dto.setJob(jobMapping.convertJobToJobDto(ja.getJob()));
        dto.setJobStatus(ja.getJobStatus());
        return dto;
    }

    public List<JobApplicationDto> convertToDto(List<JobApplication> applicationList) {
        List<JobApplicationDto> dtoList = new ArrayList<>();
        for(JobApplication ja: applicationList) {
            dtoList.add(convertToDto(ja));
        }
        return dtoList;
    }
}
