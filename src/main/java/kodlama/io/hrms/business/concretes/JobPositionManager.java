package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobPositionCheckService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;
    private final JobPositionCheckService jobPositionCheckService;

    public JobPositionManager(JobPositionDao jobPositionDao, JobPositionCheckService jobPositionCheckService) {
        this.jobPositionDao = jobPositionDao;
        this.jobPositionCheckService = jobPositionCheckService;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>
                (this.jobPositionDao.findAll(), "Job Positions Listed.");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (this.jobPositionCheckService.checkJobPosition(jobPosition).isSuccess() == false) {
            return this.jobPositionCheckService.checkJobPosition(jobPosition);
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job Position added successfully");
    }
}
