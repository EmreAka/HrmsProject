package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobPositionCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionCheckManager implements JobPositionCheckService {

    private final JobPositionDao jobPositionDao;

    public JobPositionCheckManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result checkJobPosition(JobPosition jobPosition) {
        if (this.jobPositionDao.existsByPosition(jobPosition.getPosition())) {
            return new ErrorResult("This position already exists.");
        }
        return new SuccessResult();
    }
}
