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
public class EmployeeNationalIdCheckService implements EmployeeCheckService {

    @Autowired
    private EmployeeDao employeeDao;

/*    @Override
    public Result checkEmployee(Employee employee) {
        List<Employee> employees = this.employeeDao.findAll();
        for (Employee emp : employees) {
            if (emp.getNationalId().equals(employee.getNationalId())) {
                return new ErrorResult("This national id already exists. Please try another one.");
            }
        }
        return new SuccessResult();
    }
}*/

    @Override
    public Result checkEmployee(Employee employee) {
        if (this.employeeDao.existsByNationalId(employee.getNationalId())) {
            return new ErrorResult("This national id is used before, please try another one.");
        }
        return new SuccessResult();
    }
}