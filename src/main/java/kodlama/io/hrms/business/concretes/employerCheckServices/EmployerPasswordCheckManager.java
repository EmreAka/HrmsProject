package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerPasswordCheckManager implements EmployerCheckService {

    @Override
    public Result checkEmployer(Employer employer) {
        if (!employer.getPassword().equals(employer.getSecondPassword())) {
            return new ErrorResult("Passwords should be the same.");
        }
        return new SuccessResult();
    }

}
