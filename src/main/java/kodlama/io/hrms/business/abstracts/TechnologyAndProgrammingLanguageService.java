package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;

import java.util.List;

public interface TechnologyAndProgrammingLanguageService {
    Result add(TechnologyAndProgrammingLanguage technologyAndProgrammingLanguage);
    DataResult<List<TechnologyAndProgrammingLanguage>> getAll();
}
