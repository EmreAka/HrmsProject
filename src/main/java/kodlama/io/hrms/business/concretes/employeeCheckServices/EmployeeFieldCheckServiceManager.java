package kodlama.io.hrms.business.concretes.employeeCheckServices;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFieldCheckServiceManager implements EmployeeCheckService {

    @Override
    public Result checkEmployee(Employee employee) {
        if (employee.getEmail().isEmpty() || employee.getPassword().isEmpty() ||
                employee.getFirstName().isEmpty() ||
                employee.getLastName().isEmpty() || employee.getNationalId().isEmpty() ||
                employee.getBirthYear() == null) {
            return new ErrorResult("You have to fill all of slots.");
        }

        return new SuccessResult();
    }
}
