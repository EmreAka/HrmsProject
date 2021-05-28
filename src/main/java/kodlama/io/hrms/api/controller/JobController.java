package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getall")
    public DataResult<List<Job>> getAll() {
        return this.jobService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Job job) {
        return this.jobService.add(job);
    }

    @GetMapping("/getAllActiveJobs")
    public DataResult<List<Job>> findAllByActiveTrue() {
        return this.jobService.findAllByActiveTrue();
    }

    @GetMapping("/getAllSortedByCreatedTimes")
    public DataResult<List<Job>> getAllSorted() {
        return this.jobService.getAllSorted();
    }

    @GetMapping("/getAllByEmployer")
    public DataResult<List<Job>> findAllByEmployerId(@RequestParam int employerId) {
        return this.jobService.findAllByEmployerId(employerId);
    }

}