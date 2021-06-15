package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyAndProgrammingLanguageDao extends JpaRepository<TechnologyAndProgrammingLanguage, Integer> {
    TechnologyAndProgrammingLanguage findById(int id);
    List<TechnologyAndProgrammingLanguage> findAllByCv_Id(int id);
}
