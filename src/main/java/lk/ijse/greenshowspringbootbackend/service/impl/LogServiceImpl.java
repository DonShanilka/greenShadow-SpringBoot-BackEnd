package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.LogDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import lk.ijse.greenshowspringbootbackend.entity.impl.Log;
import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.exception.LogNotFoundException;
import lk.ijse.greenshowspringbootbackend.repo.CropRepo;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.LogRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.LogService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepo logRepo;
    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private CropRepo cropRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void saveLog(LogDTO logDTO) {
        String logCode = appUtil.generateLogId();

        if (logRepo.existsById(logCode)) {
            throw new DataPersistException(logCode + " - LogCode already exists");
        }
        List<String> logFields = new ArrayList<>();
        for (FieldDTO fieldDTO : logDTO.getRelevantFields()){
            logFields.add(fieldDTO.getFieldCode());
        }
        List<String> logCrops = new ArrayList<>();
        for (CropDTO cropDTO : logDTO.getRelevantCrops()){
            logCrops.add(cropDTO.getCropCode());
        }
        List<String> logStaffs = new ArrayList<>();
        for (StaffDTO staffDTO : logDTO.getRelevantStaff()){
            logStaffs.add(staffDTO.getId());
        }

        List<Field> fields = fieldRepo.findAllById(logFields);
        List<Crop> crops = cropRepo.findAllById(logCrops);
        List<Staff> staffs = staffRepo.findAllById(logStaffs);
        Log log = mapping.mapLogDtoToEntity(logDTO);

        log.setFields(fields);
        log.setCrops(crops);
        log.setStaffs(staffs);
        logRepo.save(log);

    }

    @Override
    public List<LogDTO> getLogs() {
        return mapping.mapLogEntitiesToDtos(logRepo.findAll());
    }

    @Override
    public void deleteLog(String logCode) {
        if (!logRepo.existsById(logCode)) {
            throw new LogNotFoundException(logCode + " - Log does not exist");
        }
    }
}
