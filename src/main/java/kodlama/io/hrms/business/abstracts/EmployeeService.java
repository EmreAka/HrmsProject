package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result add(Employee employee);
}
