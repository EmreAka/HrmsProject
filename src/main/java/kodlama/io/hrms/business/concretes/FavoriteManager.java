package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.FavoriteService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.FavoriteDao;
import kodlama.io.hrms.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public DataResult<List<Favorite>> findAllByEmployeeId(int id) {
        return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAllByEmployee_Id(id), "Favorites listed by employee");
    }

    @Override
    public Result add(Favorite favorite) {
        this.favoriteDao.save(favorite);
        return new SuccessResult("Favorite saved successfully");
    }

    @Override
    public Result delete(Favorite favorite) {
        this.favoriteDao.delete(favorite);
        return new SuccessResult("Favorite deleted successfully");
    }

    @Override
    public Result deleteById(int id) {
        this.favoriteDao.deleteById(id);
        return new SuccessResult("Favorite deleted successfully");
    }
}
