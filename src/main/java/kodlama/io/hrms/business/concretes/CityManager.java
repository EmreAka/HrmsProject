package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityManager implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public DataResult<List<City>> findAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities are listed successfully!");
    }
}
