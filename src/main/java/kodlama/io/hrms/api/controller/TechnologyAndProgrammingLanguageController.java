package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.TechnologyAndProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TechnologyAndProgrammingLanguages")
public class TechnologyAndProgrammingLanguageController {

    @Autowired
    private TechnologyAndProgrammingLanguageService technologyAndProgrammingLanguageService;

    @PostMapping("/add")
    public Result add(@RequestBody TechnologyAndProgrammingLanguage technologyAndProgrammingLanguage) {
        return this.technologyAndProgrammingLanguageService.add(technologyAndProgrammingLanguage);
    }

    @GetMapping("/getAll")
    public DataResult<List<TechnologyAndProgrammingLanguage>> getAll() {
        return this.technologyAndProgrammingLanguageService.getAll();
    }

}
