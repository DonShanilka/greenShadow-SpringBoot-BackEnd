package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dao.FieldDAO;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.service.FieldService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepo fieldRepo;

    @Autowired
    private Mapping mapping;

    public String generateCropId() {
        // Fetch the last crop ID
        String lastId = fieldRepo.findLastCropCode();

        if (lastId != null && lastId.startsWith("F")) {
            // Extract the numeric part and increment
            int lastNumber = Integer.parseInt(lastId.substring(1));
            return String.format("F%03d", lastNumber + 1);
        } else {
            // Default ID for the first entry
            return "F001";
        }
    }

    @Override
    public void saveField(FieldDTO fieldDTO) {
        Field saveField = fieldRepo.save(mapping.mapFieldDtoToEntity(fieldDTO));
        if (saveField == null) {
            throw new DataPersistException("Field save failed");
        }
    }

    @Override
    public List<FieldDTO> getAllField() {
        return List.of();
    }

    @Override
    public CropStatus getFieldById(String fieldCode) {
        return null;
    }

    @Override
    public void deleteFieldById(String fieldCode) {

    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
