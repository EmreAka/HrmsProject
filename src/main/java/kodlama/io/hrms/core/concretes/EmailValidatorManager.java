package kodlama.io.hrms.core.concretes;

import kodlama.io.hrms.core.abstracts.EmailValidator;
import kodlama.io.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class EmailValidatorManager implements EmailValidator {
    @Override
    public boolean isEmailValidated(User user) {
        return true;
    }
}
