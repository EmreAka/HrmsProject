package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.concretes.CloudinaryServiceAdapter;
import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
public class CvManager implements CvService {

    @Autowired
    private CvDao cvDao;
    @Autowired
    private CloudinaryServiceAdapter cloudinaryServiceAdapter;

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv added successfully");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cvs listed successfully");
    }

    @Override
    public DataResult<List<Cv>> findAllByEmployeeId(int employeeId) {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAllByEmployee_Id(employeeId), "Cvs listed successfully");
    }

    @Override
    public DataResult<String> uploadPhoto(int id, String filePath) {
        File file = new File(filePath);
        Object object = this.cloudinaryServiceAdapter.upload(file).get("secure_url");
        if ((object == null)) {
            return new ErrorDataResult<String>(null, "Failed to load photo! Not found image.");

        } else if (!this.cvDao.existsById(id)) {
            return new ErrorDataResult<String>(null, "Failed to load photo! Not found cv.");
        } else {
            String secure_url = object.toString();
            Cv cv = this.cvDao.findById(id).get();
            cv.setPhoto(secure_url);
            this.cvDao.save(cv);
            return new SuccessDataResult<String>(secure_url, "Photo upload successfully.");
        }
    }
}
