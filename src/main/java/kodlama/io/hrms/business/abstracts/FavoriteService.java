package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Favorite;

import java.util.List;

public interface FavoriteService {
    DataResult<List<Favorite>> findAllByEmployeeId(int id);
    Result add(Favorite favorite);
}
