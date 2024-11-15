package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.CropStatus;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropStatus getCropById(String cropCode);
    void deleteCropById(String cropCode);
    void updateCrop(String cropCode,CropDTO cropDTO);
}
