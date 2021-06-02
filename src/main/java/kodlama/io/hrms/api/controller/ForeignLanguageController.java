package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.ForeignLangaugeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foreignLanguages")
public class ForeignLanguageController {

    @Autowired
    private ForeignLangaugeService foreignLangaugeService;

    @PostMapping("/add")
    public Result add(@RequestBody ForeignLanguage foreignLanguage) {
        return this.foreignLangaugeService.add(foreignLanguage);
    }

    @GetMapping("/getAll")
    public DataResult<List<ForeignLanguage>> getAll() {
        return this.foreignLangaugeService.getAll();
    }
}
