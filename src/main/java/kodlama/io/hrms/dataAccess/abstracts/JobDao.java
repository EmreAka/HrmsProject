package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobDao extends JpaRepository<Job, Integer> {
    List<Job> findAllByActiveTrue();
    List<Job> findAllByEmployer_IdAndActiveTrue(int employerId);
    List<Job> findAllByActiveTrueOrderByCreatedTimeDesc();
    Job findByIdAndActiveTrueOrderByCreatedTimeDesc(int id);
}
