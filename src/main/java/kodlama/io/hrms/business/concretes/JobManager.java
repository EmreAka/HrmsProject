package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByActiveTrueOrderByCreatedTimeDesc(), "Jobs listed by created times.");
    }

    @Override
    public DataResult<Job> findByIdAndActiveTrueOrderByCreatedTimeDesc(int id) {
        return new SuccessDataResult<Job>(this.jobDao.findByIdAndActiveTrueOrderByCreatedTimeDesc(id), "Jobs listed by id.");
    }

    @Override
    public Result setValue(int id, boolean value) {
        Job job = this.jobDao.findById(id).get();
        if (job == null) {
            return new ErrorResult("There is no job which has that id number.");
        }
        job.setActive(value);
        this.jobDao.save(job);
        return new SuccessResult("Value setted to " + value + " successfully.");
    }
}
