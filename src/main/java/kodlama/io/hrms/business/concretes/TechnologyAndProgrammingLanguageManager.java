package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.TechnologyAndProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TechnologyAndProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.TechnologyAndProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnologyAndProgrammingLanguageManager implements TechnologyAndProgrammingLanguageService {

    @Autowired
    private TechnologyAndProgrammingLanguageDao technologyAndProgrammingLanguageDao;


    @Override
    public Result add(TechnologyAndProgrammingLanguage technologyAndProgrammingLanguage) {
        this.technologyAndProgrammingLanguageDao.save(technologyAndProgrammingLanguage);
        return new SuccessResult("Technology or Programming Language added successfully");
    }

    @Override
    public DataResult<List<TechnologyAndProgrammingLanguage>> getAll() {
        return new SuccessDataResult<List<TechnologyAndProgrammingLanguage>>(this.technologyAndProgrammingLanguageDao.findAll(), "Technology or Programming Languages listed successfully");
    }
}
