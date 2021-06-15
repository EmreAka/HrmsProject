package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
    List<ForeignLanguage> findAllByCv_Id(int id);
}
