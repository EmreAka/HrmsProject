package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    @Autowired
    private JobExperienceDao jobExperienceDao;

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Job Experience added successfully");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "Job Experiences listed successfully");
    }

    @Override
    public DataResult<List<JobExperience>> findAllByCvIdOrderByFinishDateDesc(int cvId) {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCv_IdOrderByFinishDateDesc(cvId), "Job Experiences listed by Cv id and ordered by finish dates successfully.");
    }
}
