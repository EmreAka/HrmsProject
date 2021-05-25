package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobpositions")
public class JobPositionController {
    //@Autowired diyerek constructor oluşturmasak dahi çalışır fakat...
    //her değişken için @Autowired yazmamız gerekir
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll() {
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }
}
