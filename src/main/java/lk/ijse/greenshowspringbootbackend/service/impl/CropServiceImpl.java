package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dao.CropDAO;
import lk.ijse.greenshowspringbootbackend.dto.CropStatus;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.service.CropService;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {

    private static List<CropDTO> crops = new ArrayList<>();

    @Autowired
    private CropDAO cropDAO;
    @Autowired
    private Mapping cropMapping;


    @Override
    public void saveCrop(CropDTO cropDTO) {

    }

    @Override
    public List<CropDTO> getAllCrops() {
        return List.of();
    }

    @Override
    public CropStatus getCropById(String cropCode) {
        return null;
    }

    @Override
    public void deleteCropById(String cropCode) {

    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {

    }
}