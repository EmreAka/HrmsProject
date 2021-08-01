package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvController {

    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

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

    @GetMapping("/findAllById")
    public DataResult<Cv> findAllById(int id){
        return this.cvService.findById(id);
    }


    @PutMapping("/uploadImage")
    public Result uploadPhoto(@RequestBody MultipartFile file,@RequestParam int cvId) {
        return this.cvService.uploadPhoto(file, cvId);
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

