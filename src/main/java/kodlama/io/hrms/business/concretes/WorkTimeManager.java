package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.WorkTimeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlama.io.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkTimeManager implements WorkTimeService {

    private final WorkTimeDao workTimeDao;

    public WorkTimeManager(WorkTimeDao workTimeDao) {
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> findAll() {
        return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll(), "Work Times are listed successfully!");
    }
}
