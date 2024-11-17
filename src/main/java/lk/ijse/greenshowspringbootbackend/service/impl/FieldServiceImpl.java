package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dao.FieldDAO;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.service.FieldService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private CropRepo cropRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        String newCropId = appUtil.generateFieldId();

        if (fieldRepo.existsById(newCropId)) {
            throw new DataPersistException("Crop ID " + newCropId + " already exists");
        }

        Field field = mapping.mapFieldDtoToEntity(fieldDTO);
        field.setFieldCode(newCropId);
        fieldRepo.save(field);
    }

    @Override
    public List<FieldDTO> getAllField() {
        return mapping.mapFieldEntitiesToDtos(fieldRepo.findAll());
    }

    @Override
    public CropStatus getFieldById(String fieldCode) {
        return null;
    }

    @Override
    public void deleteFieldById(String fieldCode) throws FileNotFoundException {
        if (!fieldRepo.existsById(fieldCode)) {
            throw new FileNotFoundException("Crop ID " + fieldCode + " does not exist");
        }
        fieldRepo.deleteById(fieldCode);
    }

    @Override
    public void updateField(FieldDTO fieldDTO) throws FileNotFoundException {
        if (!fieldRepo.existsById(fieldDTO.getFieldCode())) {
            throw new FileNotFoundException("Field code " + fieldDTO.getFieldCode() + " does not exist");
        }
        fieldRepo.save(mapping.mapFieldDtoToEntity(fieldDTO));
    }

    @Override
    public void saveFieldCrops(FieldDTO fieldDTO) {
        Optional<Field> optionalField = fieldRepo.findById(fieldDTO.getFieldCode());
        Optional<Crop> optionalCrop = cropRepo.findById()
    }

    @Override
    public void deleteFieldCrops(String fieldCode, String cropCode) throws FileNotFoundException {

    }
}
