package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.FavoriteCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.FavoriteDao;
import kodlama.io.hrms.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteCheckManager implements FavoriteCheckService {
    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public Result checkFavorite(Favorite favorite) {
        if (this.favoriteDao.existsByJob_Id(favorite.getJob().getId())){
            return new ErrorResult("This favorite job already exists!");
        }
        return new SuccessResult();
    }
}
