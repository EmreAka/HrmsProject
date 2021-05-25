package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerFieldCheckServiceManager implements EmployerCheckService {
    @Override
    public Result checkEmployer(Employer employer) {
        if(employer.getEmail().isEmpty() || employer.getPassword().isEmpty() ||
                employer.getCompanyName().isEmpty() ||
        employer.getPhoneNumber().isEmpty() || employer.getWebSite().isEmpty()) {
            return new ErrorResult("You have to fill all of slots.");
        }

        return new SuccessResult();
    }
}
