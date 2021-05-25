package kodlama.io.hrms.adapters.concretes;

import kodlama.io.hrms.adapters.abstracts.MernisService;
import kodlama.io.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisService {
    @Override
    public boolean isTurkishCitizen(Employee employee) {
        //We would put our mernis codes which returns boolean result.
        return true;
    }
}
