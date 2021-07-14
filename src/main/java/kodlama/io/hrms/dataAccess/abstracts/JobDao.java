package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JobDao extends PagingAndSortingRepository<Job, Integer> {
    List<Job> findAllByActiveTrue();
    List<Job> findAllByEmployer_IdAndActiveTrue(int employerId);
    List<Job> findAllByEmployer_IdAndActiveTrueAndValidateTrue(int employerId);
    List<Job> findAllByActiveTrueOrderByCreatedTimeDesc();
    List<Job> findAllByActiveTrueAndValidateTrueOrderByCreatedTimeDesc();
    List<Job> findAllByActiveTrueAndValidateTrueOrderByCreatedTimeDesc(Pageable pageable);
    List<Job> findAllByValidateFalseOrderByCreatedTimeDesc();
    Job findByIdAndActiveTrueOrderByCreatedTimeDesc(int id);
}
