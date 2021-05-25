package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }
}
