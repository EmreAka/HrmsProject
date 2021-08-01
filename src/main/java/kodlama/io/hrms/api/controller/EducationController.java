package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.entities.concretes.Education;
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
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Education education) {
        return ResponseEntity.ok(this.educationService.add(education));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam int id) {
        return ResponseEntity.ok(this.educationService.deleteById(id));
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll() {
        return this.educationService.getAll();
    }

    @GetMapping("/findAllByCvIdOrderByFinishDateDesc")
    public DataResult<List<Education>> findAllByCvIdOrderByFinishDateDesc(int cvId){
        return this.educationService.findAllByCvIdOrderByFinishDateDesc(cvId);
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
