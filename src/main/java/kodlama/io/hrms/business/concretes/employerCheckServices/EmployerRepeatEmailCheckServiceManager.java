package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerRepeatEmailCheckServiceManager implements EmployerCheckService {

    @Autowired
    private EmployerDao employerDao;

    @Override
    public Result checkEmployer(Employer employer) {
        if (this.employerDao.existsByEmail(employer.getEmail())) {
            return new ErrorResult("This email adress is already used, please try another one.");
        }
        return new SuccessResult();
    }
}
