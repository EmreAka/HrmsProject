package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionCheckService {
    Result checkJobPosition(JobPosition jobPosition);
}
