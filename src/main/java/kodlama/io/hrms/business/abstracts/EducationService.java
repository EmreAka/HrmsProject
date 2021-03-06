package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result add(Education education);
    Result deleteById(int id);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> findAllByCvIdOrderByFinishDateDesc(int cvId);
}
