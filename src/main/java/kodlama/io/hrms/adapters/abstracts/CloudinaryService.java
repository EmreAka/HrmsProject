package kodlama.io.hrms.adapters.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> uploadPhoto(MultipartFile file);
}
