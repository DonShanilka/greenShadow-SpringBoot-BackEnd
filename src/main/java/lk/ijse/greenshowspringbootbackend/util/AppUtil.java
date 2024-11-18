package lk.ijse.greenshowspringbootbackend.util;

import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.repo.EquipmentRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.UUID;

@RestController
public class AppUtil {

    @Autowired
    private CropRepo cropRepository;
    @Autowired
    private FieldRepo fieldRepository;
    @Autowired
    private EquipmentRepo equipmentRepository;
    @Autowired
    private LogRepo logRepository;

    public static String imageBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }

    public String generateFieldId() {
        // Fetch the last crop ID
        String lastId = fieldRepository.findLastFieldCode();

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
        String lastId = equipmentRepository.findLastEquipmentCode();

        if (lastId != null && lastId.startsWith("E")) {
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("E%03d", lastNumber + 1);
        } else {
            return "E001";
        }
    }

    public String generateLogId() {
        String lastId = logRepository.findLastLogCode();

        if (lastId != null && lastId.startsWith("L")) {
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("L%03d", lastNumber + 1);
        } else {
            return "L001";
        }
    }
}
