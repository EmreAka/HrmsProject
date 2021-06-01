package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.abstracts.MernisService;
import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.abstracts.MailValidator;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCheckManager implements EmployeeCheckService {

    private UserDao userDao;
    private EmployeeDao employeeDao;
    private MailValidator mailValidator;
    private MernisService mernisService;

    @Autowired
    public EmployeeCheckManager(UserDao userDao, EmployeeDao employeeDao, MailValidator mailValidator, MernisService mernisService) {
        this.userDao = userDao;
        this.employeeDao = employeeDao;
        this.mailValidator = mailValidator;
        this.mernisService = mernisService;
    }

    @Override
    public Result checkEmployee(Employee employee) {
        if (!this.mailValidator.isEmailValidated(employee)) {
            return new ErrorResult("Email could not validated.");
        }
        if (!this.mernisService.isTurkishCitizen(employee)) {
            return new ErrorResult("You're not Turkish citizen.");
        }
        if (this.employeeDao.existsByNationalId(employee.getNationalId())) {
            return new ErrorResult("This national id is used before, please try another one.");
        }
        if (!employee.getPassword().equals(employee.getSecondPassword())) {
            return new ErrorResult("Password should be the same.");
        }
        if (this.userDao.existsByEmail(employee.getEmail())) {
            return new ErrorResult("This email is used before. Please try another one.");
        }
        return new SuccessResult();
    }
}
