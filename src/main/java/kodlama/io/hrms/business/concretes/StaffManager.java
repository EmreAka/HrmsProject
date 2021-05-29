package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.StaffService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class StaffManager implements StaffService {

    @Override
    public boolean validateEmployer() {
        return true;
    }
}
