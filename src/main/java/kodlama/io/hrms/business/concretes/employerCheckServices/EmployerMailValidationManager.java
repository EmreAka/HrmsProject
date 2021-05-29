package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.abstracts.MailValidator;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerMailValidationManager implements EmployerCheckService {

    @Autowired
    private MailValidator mailValidator;

    @Override
    public Result checkEmployer(Employer employer) {
        if (this.mailValidator.isEmailValidated(employer)) {
            return new SuccessResult();
        }

        return new ErrorResult("Email could not validated.");
    }
}
