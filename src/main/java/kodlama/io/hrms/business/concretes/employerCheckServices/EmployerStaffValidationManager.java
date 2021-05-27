package kodlama.io.hrms.business.concretes.employerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.StaffService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerStaffValidationManager implements EmployerCheckService {
    @Autowired
    private StaffService staffService;

    @Override
    public Result checkEmployer(Employer employer) {
        if (this.staffService.validateEmployer()) {
            return new SuccessResult();
        }
        return new ErrorResult("Admin rejected your request");
    }
}
