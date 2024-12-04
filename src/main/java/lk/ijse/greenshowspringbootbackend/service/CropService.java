package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;

import java.io.FileNotFoundException;
import java.util.List;

public interface CropService {
    void saveFieldCrops(CropDTO cropDTO);
    void updateFieldCrops(CropDTO cropDTO) throws FileNotFoundException;
    void deleteCrop(String cropCode);
    List<CropDTO> getAllCrops();
}
