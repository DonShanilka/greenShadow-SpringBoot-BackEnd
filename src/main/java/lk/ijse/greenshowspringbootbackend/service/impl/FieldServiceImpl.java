package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dao.FieldDAO;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
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

    private static List<FieldDTO> f = new ArrayList<>();

    @Autowired
    private FieldDAO fieldDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        if (fieldDTO.getFieldCode() == null || fieldDTO.getFieldCode().isEmpty()) {
            fieldDTO.setFieldCode(AppUtil.generateCropCode());
        }
        Field field = mapping.to(fieldDTO);
        Crop savedCrop = cropDAO.save(cropEntity);
        // Throw an exception if save operation failed
        if (savedCrop == null) {
            throw new DataPersistException("Crop Not Saved");
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
