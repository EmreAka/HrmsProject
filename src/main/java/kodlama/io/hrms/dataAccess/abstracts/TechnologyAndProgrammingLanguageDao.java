package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyAndProgrammingLanguageDao extends JpaRepository<TechnologyAndProgrammingLanguage, Integer> {
}
