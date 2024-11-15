package lk.ijse.greenshowspringbootbackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCropCode(){
        return "Crop" + UUID.randomUUID();
    }

    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }

}
