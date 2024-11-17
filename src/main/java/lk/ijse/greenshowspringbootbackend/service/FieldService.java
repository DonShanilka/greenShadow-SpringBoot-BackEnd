package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldCropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO> getAllField();
    CropStatus getFieldById(String fieldCode);
    void deleteFieldById(String fieldCode) throws FileNotFoundException;
    void updateField(FieldDTO fieldDTO) throws FileNotFoundException;
    void saveFieldCrops(FieldCropDTO fieldCropDTO) throws FileNotFoundException;
    void deleteFieldCrops(String fieldCode, String cropCode) throws FileNotFoundException;
}
