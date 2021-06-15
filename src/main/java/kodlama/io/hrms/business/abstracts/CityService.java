package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> findAll();
}
