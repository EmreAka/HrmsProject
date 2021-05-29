package kodlama.io.hrms.core.concretes;

import kodlama.io.hrms.core.abstracts.MailValidator;
import kodlama.io.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class MailValidatorManager implements MailValidator {
    @Override
    public boolean isEmailValidated(User user) {
        return true;
    }
}
