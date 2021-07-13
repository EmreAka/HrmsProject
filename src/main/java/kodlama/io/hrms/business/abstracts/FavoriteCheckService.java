package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Favorite;

public interface FavoriteCheckService {
    Result checkFavorite(Favorite favorite);
}
