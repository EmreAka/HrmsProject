package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmployerMailRegexCheckServiceManager implements EmployerCheckService {

    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public Result checkEmployer(Employer employer) {
        if (!emailValidator.isValid(employer.getEmail())) {
            return new ErrorResult("This is not an email adress. Please use an email adress.");
        }

        return new SuccessResult();
    }
}
