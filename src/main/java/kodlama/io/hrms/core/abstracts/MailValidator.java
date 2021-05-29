package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface MailValidator {
    boolean isEmailValidated(User user);
}
