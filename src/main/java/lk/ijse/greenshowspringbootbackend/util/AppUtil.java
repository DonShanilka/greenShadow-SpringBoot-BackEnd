package lk.ijse.greenshowspringbootbackend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCropCode(){
        return "Crop" + UUID.randomUUID();
    }

    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }

    public static String generateFieldCode(String lastFieldCode) {
        if (lastFieldCode == null || lastFieldCode.isEmpty() || !lastFieldCode.matches("^F\\d+$")) {
            return "F001";
        } else {
            String numericPart = lastFieldCode.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "F00" + nextNumericPart;
        }
    }

    public static String generateCropCode(String lastCropCode) {
        if (lastCropCode == null || lastCropCode.isEmpty() || !lastCropCode.matches("^C\\d+$")) {
            return "C001";
        } else {
            String numericPart = lastCropCode.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "C00" + nextNumericPart;
        }
    }

}
