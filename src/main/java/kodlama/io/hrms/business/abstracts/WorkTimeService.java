package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    DataResult<List<WorkTime>> findAll();
}
