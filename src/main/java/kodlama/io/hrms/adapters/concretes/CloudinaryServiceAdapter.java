package kodlama.io.hrms.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@Service
public class CloudinaryServiceAdapter {

    @SuppressWarnings("unchecked")
    public Map<String, Object> upload(File file) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "emreaka",
                "api_key", "281473766344166",
                "api_secret", "EaaFNJek7NNh7ghVtFGBLQjrm3A"));
        try {
            @SuppressWarnings("rawtypes")
            Map params = ObjectUtils.asMap(
                    "folder", "cv/photos/",
                    "public_id", null,
                    "overwrite", true,
                    "notification_url", null,
                    "resource_type", "image"
            );
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file, params);
            return uploadResult;
            //System.out.println(uploadResult.get("secure_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ObjectUtils.emptyMap();
    }


}
