package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.abstracts.CloudinaryService;
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
import java.util.Map;

@Service
public class CvManager implements CvService {

    @Autowired
    private CvDao cvDao;
    @Autowired
    private CloudinaryService cloudinaryService;

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
    public Result uploadPhoto(MultipartFile file, int cvId) {
        Map<String, String> uploader = (Map<String, String>)
                cloudinaryService.uploadPhoto(file).getData();
        String imageUrl= uploader.get("url");
        Cv cv = cvDao.getOne(cvId);
        cv.setPhoto(imageUrl);
        cvDao.save(cv);
        return new SuccessResult("Kayıt Başarılı");
    }

    @Override
    public DataResult<Cv> findById(int id) {
        return new SuccessDataResult<Cv>(this.cvDao.findById(id), "Data listed");
    }

}
