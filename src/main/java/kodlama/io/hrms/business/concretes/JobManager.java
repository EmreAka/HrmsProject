package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobManager implements JobService {
    @Autowired
    private JobDao jobDao;

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Jobs listed successfully.");
    }

    @Override
    public Result add(Job job) {
        this.jobDao.save(job);
        return new SuccessResult("Job added successfully.");
    }

    @Override
    public DataResult<List<Job>> findAllByActiveTrue() {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByActiveTrue(), "Active Jobs listed Successfully.");
    }

    @Override
    public DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(int employerId) {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByEmployer_IdAndActiveTrue(employerId), "Jobs listed by employer.");
    }

    @Override
    public DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc() {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByActiveTrueOrderByCreatedTimeDesc(), "Listed by created times.");
    }
}
