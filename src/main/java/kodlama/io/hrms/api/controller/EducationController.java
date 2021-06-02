package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("/add")
    public Result add(@RequestBody Education education) {
        return this.educationService.add(education);
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll() {
        return this.educationService.getAll();
    }
}
