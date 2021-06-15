package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {
}
