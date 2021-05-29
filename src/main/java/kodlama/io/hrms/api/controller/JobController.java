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

    @GetMapping("/findAllByActiveTrue")
    public DataResult<List<Job>> findAllByActiveTrue() {
        return this.jobService.findAllByActiveTrue();
    }

    @GetMapping("/findAllByEmployerIdAndActiveTrue")
    public DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(@RequestParam int employerId) {
        return this.jobService.findAllByEmployerIdAndActiveTrue(employerId);
    }

    @GetMapping("/findAllByActiveTrueOrderByCreatedTimeDesc")
    public DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc() {
        return this.jobService.findAllByActiveTrueOrderByCreatedTimeDesc();

    }

    @PutMapping("/setValue")
    public Result setValue(@RequestParam int id,@RequestParam boolean value) {
        return this.jobService.setValue(id, value);
    }
}