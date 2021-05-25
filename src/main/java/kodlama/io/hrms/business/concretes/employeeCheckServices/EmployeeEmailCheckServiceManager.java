package kodlama.io.hrms.business.concretes.employeeCheckServices;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEmailCheckServiceManager implements EmployeeCheckService {

    @Autowired
    private EmployeeDao employeeDao;

/*    @Override
    public Result checkEmployee(Employee employee) {
        List<Employee> employees = this.employeeDao.findAll();
        for (Employee emp : employees) {
            if (emp.getEmail().equals(employee.getEmail())) {
                return new ErrorResult("This email already exists. Please try another one.");
            }
        }

        return new SuccessResult();
    }
}*/
    @Override
    public Result checkEmployee(Employee employee) {
        if (this.employeeDao.existsByEmail(employee.getEmail())) {
            return new ErrorResult("This email is used before. Please try another one.");
        }
        return new SuccessResult();
    }
}
