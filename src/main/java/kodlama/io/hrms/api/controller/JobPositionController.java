package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobPositionService;
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
    public List<JobPosition> getAll() {
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition) {
        this.jobPositionService.add(jobPosition);
    }
}
