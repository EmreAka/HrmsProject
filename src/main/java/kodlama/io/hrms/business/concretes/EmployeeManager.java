package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeCheckService[] employeeCheckServices;
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmployeeCheckService[] employeeCheckServices) {
        this.employeeDao = employeeDao;
        this.employeeCheckServices = employeeCheckServices;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(), "Employees listed.");
    }

    @Override
    public Result add(Employee employee) {
        for (EmployeeCheckService employeeCheckService : employeeCheckServices) {
            if (employeeCheckService.checkEmployee(employee).isSuccess() == false) {
                return employeeCheckService.checkEmployee(employee);
            }
        }
        this.employeeDao.save(employee);
        return new SuccessResult("Added successfully");
    }
}
