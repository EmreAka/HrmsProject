package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.ActivisionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivisionEmployeeDao extends JpaRepository<ActivisionEmployee, Integer> {
}
