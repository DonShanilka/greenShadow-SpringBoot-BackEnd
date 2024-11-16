package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.service.CropService;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {

    @Autowired
    private CropRepo cropRepo;

    @Autowired
    private Mapping mapping;

    @Autowired
    private CropRepo cropRepository;

    public String generateCropId() {
        // Fetch the last crop ID
        String lastId = cropRepository.findLastCropCode();

        if (lastId != null && lastId.startsWith("C")) {
            // Extract the numeric part and increment
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("C%03d", lastNumber + 1);
        } else {
            // Default ID for the first entry
            return "C001";
        }
    }


    @Override
    public void saveFieldCrops(CropDTO cropDTO) {
        // Generate a new crop ID
        String newCropId = generateCropId();
        // Check if the new ID already exists in the database
        if (cropRepo.existsById(newCropId)) {
            throw new DataPersistException("Crop ID " + newCropId + " already exists");
        }
        // Map the CropDTO to a Crop entity and set the generated ID
        Crop cropEntity = mapping.mapCropDtoToEntity(cropDTO);
        cropEntity.setCropCode(newCropId);
        // Save the crop entity to the database
        cropRepo.save(cropEntity);
    }

    @Override
    public void updateFieldCrops(CropDTO cropDTO) {

    }

    @Override
    public void deleteCrop(String cropCode) {

    }

    @Override
    public List<CropDTO> getAllCrops() {
        return List.of();
    }

    @Override
    public String findLastCropCode() {
//        return cropRepo.findLastCropCode();
        return null;
    }
}