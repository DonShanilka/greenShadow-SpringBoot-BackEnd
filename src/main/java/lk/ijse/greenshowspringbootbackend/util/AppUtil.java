package lk.ijse.greenshowspringbootbackend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

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

    public static String generateLogCode(String lastLogCode) {
        if (lastLogCode == null || lastLogCode.isEmpty() || !lastLogCode.matches("^L\\d+$")) {
            return "L001";
        } else {
            String numericPart = lastLogCode.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "L00" + nextNumericPart;
        }
    }

    public static String generateStaffId(String lastStaffId) {
        if (lastStaffId == null || lastStaffId.isEmpty() || !lastStaffId.matches("^S\\d+$")) {
            return "S001";
        } else {
            String numericPart = lastStaffId.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "S00" + nextNumericPart;
        }
    }

    public static String generateEquipmentId(String lastEquipmentId) {
        if (lastEquipmentId == null || lastEquipmentId.isEmpty() || !lastEquipmentId.matches("^E\\d+$")) {
            return "E001";
        } else {
            String numericPart = lastEquipmentId.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "E00" + nextNumericPart;
        }
    }

    public static String generateVehicleCode(String lastVehicleCode) {
        if (lastVehicleCode == null || lastVehicleCode.isEmpty() || !lastVehicleCode.matches("^V\\d+$")) {
            return "V001";
        } else {
            String numericPart = lastVehicleCode.substring(3);
            int numericValue = Integer.parseInt(numericPart);
            int nextNumericValue = numericValue + 1;
            String nextNumericPart = String.format("%0" + numericPart.length() + "d", nextNumericValue);
            return "V00" + nextNumericPart;
        }
    }
}
