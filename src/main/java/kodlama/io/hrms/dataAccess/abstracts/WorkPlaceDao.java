package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlaceDao extends JpaRepository<WorkPlace, Integer> {
}
