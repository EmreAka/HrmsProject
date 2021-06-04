package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationManager implements EducationService {

    @Autowired
    private EducationDao educationDao;


    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Education added successfully");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Educations listed successfully");
    }

    @Override
    public DataResult<List<Education>> findAllByCvIdOrderByFinishDateDesc(int cvId) {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCv_IdOrderByFinishDateDesc(cvId), "Educations listed by cv id and ordered by finish dates successfully.");
    }
}
