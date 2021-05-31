package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Job;
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
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getall")
    public DataResult<List<Job>> getAll() {
        return this.jobService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Job job) {
        return ResponseEntity.ok(this.jobService.add(job));
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