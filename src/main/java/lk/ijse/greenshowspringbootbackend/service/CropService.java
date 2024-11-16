package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveFieldCrops(CropDTO cropDTO);
    void updateFieldCrops(String cropCode,CropDTO cropDTO);
    void deleteCrop(String cropCode);
    List<CropDTO> getAllCrops();
    String findLastCropCode();
}
