package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.WorkTimeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/worktimes")
@CrossOrigin
public class WorkTimeController {

    @Autowired
    private WorkTimeService workTimeService;

    @GetMapping("/findAll")
    public DataResult<List<WorkTime>> findAll(){
        return this.workTimeService.findAll();
    }
}
