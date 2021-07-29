package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.ForeignLangaugeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForeignLanguageManager implements ForeignLangaugeService {

    private final ForeignLanguageDao foreignLanguageDao;

    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Foreign Language is added successfully");
    }

    @Override
    public Result deleteById(int id) {
        this.foreignLanguageDao.deleteById(id);
        return new SuccessResult("Foreign Language is deleted successfully");
    }

    @Override
    public Result delete(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.delete(foreignLanguage);
        return new SuccessResult("Foreign Language is deleted successfully");
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(), "Foreign languages listed successfully");
    }

    @Override
    public DataResult<List<ForeignLanguage>> findAllByCvId(int id) {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAllByCv_Id(id), "Foreign languages listed successfully");
    }
}
