package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.FavoriteService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Favorite favorite) {
        return ResponseEntity.ok(this.favoriteService.add(favorite));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Favorite favorite) {
        return ResponseEntity.ok(this.favoriteService.delete(favorite));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam int id) {
        return this.favoriteService.deleteById(id);
    }

    @GetMapping("/findAllByEmployeeId")
    public DataResult<List<Favorite>> findAllByEmployeeId(@RequestParam int id){
        return this.favoriteService.findAllByEmployeeId(id);
    }

    @GetMapping("/findAll")
    public DataResult<List<Favorite>> findAll() {
        return this.favoriteService.findAll();
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
