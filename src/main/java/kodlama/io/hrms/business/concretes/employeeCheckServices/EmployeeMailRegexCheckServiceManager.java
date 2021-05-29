package kodlama.io.hrms.business.concretes.employeeCheckServices;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employee;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMailRegexCheckServiceManager implements EmployeeCheckService {

    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public Result checkEmployee(Employee employee) {
        if (!emailValidator.isValid(employee.getEmail())) {
            return new ErrorResult("This is not an email adress. Please use an email adress.");
        }

        return new SuccessResult();
    }
}
