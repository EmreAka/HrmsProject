package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;
import kodlama.io.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    DataResult<List<Job>> getAll();
    Result add(Job job);
    DataResult<List<Job>> findAllByActiveTrue();
    DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(int employerId);
    DataResult<List<Job>> findAllByEmployer_IdAndActiveTrueAndValidateTrue(int employerId);
    DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc();
    DataResult<Job> findByIdAndActiveTrueOrderByCreatedTimeDesc(int id);
    DataResult<List<Job>> findAllByActiveTrueAndValidateTrueOrderByCreatedTimeDesc();
    DataResult<List<Job>> findAllByValidateFalseOrderByCreatedTimeDesc();
    DataResult<List<Job>> findAllByActiveTrueAndValidateTrueAndWorkPlace_IdAndWorkTime_IdAndCity_IdOrderByCreatedTimeDesc(int workPlaceId, int workTimeId, int cityId);
    Result setValue(int id, boolean value);
    Result setValidateValue(int id, boolean value);
}
