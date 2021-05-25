package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeCheckService {
    Result checkEmployee(Employee employee);
}
