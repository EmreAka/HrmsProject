package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        return this.employeeService.add(employee);
    }
}
