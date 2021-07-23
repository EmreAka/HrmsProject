package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLangaugeService {
    Result add(ForeignLanguage foreignLanguage);
    Result deleteById(int id);
    Result delete(ForeignLanguage foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll();
    DataResult<List<ForeignLanguage>> findAllByCvId(int id);
}
