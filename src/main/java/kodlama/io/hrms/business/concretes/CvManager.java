package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvManager implements CvService {

    @Autowired
    private CvDao cvDao;


    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv added successfully");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cvs listed successfully");
    }

    @Override
    public DataResult<List<Cv>> findAllByEmployeeId(int employeeId) {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAllByEmployee_Id(employeeId), "Cvs listed successfully");
    }
}
