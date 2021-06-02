package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperienceController {

    @Autowired
    private JobExperienceService jobExperienceService;

    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }
}
