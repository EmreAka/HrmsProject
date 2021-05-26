package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface EmailValidator {
    boolean isEmailValidated(User user);
}
