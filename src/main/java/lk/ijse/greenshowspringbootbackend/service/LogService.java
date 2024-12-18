package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.*;

import java.io.FileNotFoundException;
import java.util.List;

public interface LogService {
    void saveLog(LogDTO logDTO);
    List<LogDTO> getLogs();
    void deleteLog(String logCode);
    void updateLog(LogDTO logDTO) throws FileNotFoundException;
    void saveLogCrops(CropLogDTO cropLogDTO);
    void saveLogField(LogFieldDTO logFieldDTO);
    void saveLogStaff(LogStaffDTO logStaffDTO);
}
