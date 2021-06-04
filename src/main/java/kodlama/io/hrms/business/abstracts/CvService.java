package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface CvService {
    Result add(Cv cv);
    DataResult<List<Cv>> getAll();
    DataResult<List<Cv>> findAllByEmployeeId(int employeeId);
    Result uploadPhoto(MultipartFile file, int cvId);
}
