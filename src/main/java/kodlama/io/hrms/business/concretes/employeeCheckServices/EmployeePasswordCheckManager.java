package kodlama.io.hrms.business.concretes.employeeCheckServices;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeePasswordCheckManager implements EmployeeCheckService {
    @Override
    public Result checkEmployee(Employee employee) {
        if (!employee.getPassword().equals(employee.getSecondPassword())) {
            return new ErrorResult("Password should be the same.");
        }

        return new SuccessResult();
    }
}
