package kodlama.io.hrms.adapters.abstracts;

import kodlama.io.hrms.entities.concretes.Employee;

public interface MernisService {
    boolean isTurkishCitizen(Employee employee);
}
