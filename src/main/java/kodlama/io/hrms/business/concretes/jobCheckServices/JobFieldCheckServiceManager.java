package kodlama.io.hrms.business.concretes.jobCheckServices;

import kodlama.io.hrms.business.abstracts.JobCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

@Service
public class JobFieldCheckServiceManager implements JobCheckService {
    @Override
    public Result checkJob(Job job) {
        if (job.getJobPosition() == null ||
        job.getDescription().isEmpty() || job.getCity() == null || String.valueOf(job.getOpenPositions()).isEmpty() ||
        job.getLatestApplyTime() == null || job.getEmployer() == null) {
            return new ErrorResult("You have to fill all of slots.");
        }
        return new SuccessResult();
    }
}
