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

import java.io.FileNotFoundException;
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
        Log log = mapping.mapLogDtoToEntity(logDTO);
        log.setLogCode(logCode);
        logRepo.save(log);

    }

    @Override
    public void updateLog(LogDTO logDTO) throws FileNotFoundException {
        if (!logRepo.existsById(logDTO.getLogCode())) {
            throw new FileNotFoundException("Log code " + logDTO.getLogCode() + " does not exist");
        }
        logRepo.save(mapping.mapLogDtoToEntity(logDTO));
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
        logRepo.deleteById(logCode);
    }
}
