package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.ForeignLangaugeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/foreignLanguages")
@CrossOrigin
public class ForeignLanguageController {

    @Autowired
    private ForeignLangaugeService foreignLangaugeService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage) {
        return ResponseEntity.ok(this.foreignLangaugeService.add(foreignLanguage));
    }

    @GetMapping("/findAllByCvId")
    public DataResult<List<ForeignLanguage>> findAllByCvId(int id){
        return this.foreignLangaugeService.findAllByCvId(id);
    }


    @GetMapping("/getAll")
    public DataResult<List<ForeignLanguage>> getAll() {
        return this.foreignLangaugeService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
        return errors;
    }

}
