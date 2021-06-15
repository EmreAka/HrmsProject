package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.WorkPlaceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
@CrossOrigin
public class WorkPlaceController {

    @Autowired
    private WorkPlaceService workPlaceService;

    @GetMapping("/findAll")
    public DataResult<List<WorkPlace>> findAll(){
        return this.workPlaceService.findAll();
    }
}
