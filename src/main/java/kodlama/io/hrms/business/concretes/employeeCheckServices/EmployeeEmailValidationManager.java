package kodlama.io.hrms.business.concretes.employeeCheckServices;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.abstracts.EmailValidator;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEmailValidationManager implements EmployeeCheckService {

    @Autowired
    private EmailValidator emailValidator;

    @Override
    public Result checkEmployee(Employee employee) {
        if (this.emailValidator.isEmailValidated(employee)) {
            return new SuccessResult();
        }

        return new ErrorResult("Email could not validated.");
    }
}