package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.StaffService;
import kodlama.io.hrms.core.abstracts.MailValidator;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerCheckManager implements EmployerCheckService {

    private EmployerDao employerDao;
    private UserDao userDao;
    private MailValidator mailValidator;
    private StaffService staffService;

    @Autowired
    public EmployerCheckManager(EmployerDao employerDao, UserDao userDao, MailValidator mailValidator, StaffService staffService) {
        this.employerDao = employerDao;
        this.userDao = userDao;
        this.mailValidator = mailValidator;
        this.staffService = staffService;
    }

    @Override
    public Result checkEmployer(Employer employer) {
        String[] splitMail = employer.getEmail().split("@");
        if (!splitMail[1].equals(employer.getWebSite())) {
            return new ErrorResult("Web site domain and your mail adress should be the same.");
        }
        if (!this.mailValidator.isEmailValidated(employer)) {
            return new ErrorResult("Email could not validated.");
        }
        if (!employer.getPassword().equals(employer.getSecondPassword())) {
            return new ErrorResult("Passwords should be the same.");
        }
        if (this.userDao.existsByEmail(employer.getEmail())) {
            return new ErrorResult("This email adress is already used, please try another one.");
        }
        if (!this.staffService.validateEmployer()) {
            return new ErrorResult("Admin rejected your request");
        }
        return new SuccessResult();
    }
}
