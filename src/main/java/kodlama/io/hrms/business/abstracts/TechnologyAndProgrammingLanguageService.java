package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;

import javax.xml.crypto.Data;
import java.util.List;

public interface TechnologyAndProgrammingLanguageService {
    Result add(TechnologyAndProgrammingLanguage technologyAndProgrammingLanguage);
    Result deleteById(int id);
    DataResult<List<TechnologyAndProgrammingLanguage>> getAll();
    DataResult<TechnologyAndProgrammingLanguage> findById(int id);
    DataResult<List<TechnologyAndProgrammingLanguage>> findAllByCvId(int id);
}
