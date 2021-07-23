package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
//If you would like to Paginate your data through custom JPA methods, you have to extend PagingAndSortingReposity.
public interface JobDao extends JpaRepository<Job, Integer> {
    List<Job> findAllByActiveTrue();
    List<Job> findAllByEmployer_IdAndActiveTrue(int employerId);
    List<Job> findAllByEmployer_IdAndActiveTrueAndValidateTrue(int employerId);
    List<Job> findAllByActiveTrueOrderByCreatedTimeDesc();
    List<Job> findAllByActiveTrueAndValidateTrueOrderByCreatedTimeDesc();
    List<Job> findAllByActiveTrueAndValidateTrueAndWorkPlace_IdAndWorkTime_IdAndCity_IdOrderByCreatedTimeDesc(int workPlaceId, int WorkTimeId, int cityId);
//    List<Job> findAllByActiveTrueAndValidateTrueOrderByCreatedTimeDesc(Pageable pageable);
    List<Job> findAllByValidateFalseOrderByCreatedTimeDesc();
    Job findByIdAndActiveTrueOrderByCreatedTimeDesc(int id);
}
