package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result add(JobExperience jobExperience);
    Result deleteById(int id);
    DataResult<List<JobExperience>> getAll();
    DataResult<List<JobExperience>> findAllByCvIdOrderByFinishDateDesc(int cvId);
}
