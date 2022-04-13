package np.com.bigbrackets.jobportal.entity.applicant;

import np.com.bigbrackets.jobportal.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public List<Applicant> getApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public Optional<Applicant> getApplicant(int applicantId) {
        return applicantRepository.findById(applicantId);
    }

    @Override
    public Applicant addApplicant(Applicant applicant) {
        applicantRepository.save(applicant);
        return applicant;
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        applicantRepository.save(applicant);
        return applicant;
    }

    @Override
    public Applicant deleteApplicant(int applicantId) {
        Applicant entity = applicantRepository.getById(applicantId);
        applicantRepository.delete(entity);
        return null;
    }

    @Override
    public Applicant getApplicantByUser(User user) {
        return applicantRepository.findByUser(user);
    }
}
