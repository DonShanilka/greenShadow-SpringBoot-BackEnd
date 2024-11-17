package lk.ijse.greenshowspringbootbackend.util;

import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.UUID;

@RestController
public class AppUtil {

    private CropRepo cropRepository;

    @Autowired
    private FieldRepo fieldRepository;

    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }

    public String generateFieldId() {
        // Fetch the last crop ID
        String lastId = fieldRepository.findLastCropCode();

        if (lastId != null && lastId.startsWith("F")) {
            // Extract the numeric part and increment
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("F%03d", lastNumber + 1);
        } else {
            // Default ID for the first entry
            return "F001";
        }
    }

    public String generateEquipmentId() {
        String lastId = fieldRepository.findLastCropCode();

        if (lastId != null && lastId.startsWith("E")) {
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("E%03d", lastNumber + 1);
        } else {
            return "E001";
        }
    }
}
