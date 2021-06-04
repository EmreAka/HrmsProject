package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
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
@RequestMapping("/api/cvs")
public class CvController {

    @Autowired
    private CvService cvService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Cv cv) {
        return ResponseEntity.ok(this.cvService.add(cv));
    }

    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("/findAllByEmployeeId")
    public DataResult<List<Cv>> findAllByEmployeeId(@RequestParam int employeeId) {
        return this.cvService.findAllByEmployeeId(employeeId);
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

