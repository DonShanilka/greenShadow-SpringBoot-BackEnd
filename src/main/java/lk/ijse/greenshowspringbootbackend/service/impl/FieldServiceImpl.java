package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldCropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.CropNotFoundException;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.FieldNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.service.FieldService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
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
    public void saveFieldCrops(FieldCropDTO fieldCropDTO) throws FileNotFoundException {
        Optional<Field> optionalField = fieldRepo.findById(fieldCropDTO.getFieldCode());
        Optional<Crop> optionalCrop = cropRepo.findById(fieldCropDTO.getCropCode());

        if (!optionalField.isPresent()) {
            throw new FileNotFoundException("Field ID " + fieldCropDTO.getFieldCode() + " does not exist");
        } else if (!optionalCrop.isPresent()) {
            throw new CropNotFoundException("Crop ID " + fieldCropDTO.getCropCode() + " does not exist");
        }
        Field field = optionalField.get();
        Crop crop = optionalCrop.get();
        if (field.getCrops().contains(crop)) {
            throw new DataPersistException(fieldCropDTO.getFieldCode() + " Field Already Exists This Crop" + crop.getCropCode());
        }
        field.getCrops().add(crop);
        crop.getFields().add(field);
        fieldRepo.save(field);
    }

    @Override
    public void deleteFieldCrops(FieldCropDTO fieldCropDTO) {
        Optional<Field> fieldOpt = fieldRepo.findById(fieldCropDTO.getFieldCode());
        Optional<Crop> cropOpt = cropRepo.findById(fieldCropDTO.getCropCode());
        if(!fieldOpt.isPresent()) {
            throw new FieldNotFoundException(fieldCropDTO.getFieldCode() + " : Field Does Not Exist");
        } else if(!cropOpt.isPresent()) {
            throw new CropNotFoundException(fieldCropDTO.getCropCode() + " : Crop Does Not Exist");
        }
        Field field = fieldOpt.get();
        Crop crop = cropOpt.get();
        field.getCrops().remove(crop);
        crop.getFields().remove(field);
        fieldRepo.save(field);
    }
}
