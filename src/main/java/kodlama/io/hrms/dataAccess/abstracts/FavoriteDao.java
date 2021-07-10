package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
    List<Favorite> findAllByEmployee_Id(int id);
    Result deleteById(int id);
}
