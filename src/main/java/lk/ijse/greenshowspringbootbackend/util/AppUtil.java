package lk.ijse.greenshowspringbootbackend.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCropCode(){
        return "Crop" + UUID.randomUUID();
    }
}
