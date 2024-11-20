package lk.ijse.greenshowspringbootbackend.service;

import lk.ijse.greenshowspringbootbackend.dto.impl.FieldStaffDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    void updateStaff(StaffDTO staffDTO);
    void deleteStaff(String staffCode);
    List<StaffDTO> getAllStaffs();
    void saveFieldStaff(FieldStaffDTO fieldStaffDTO);
    void deleteFieldStaff(String fieldCode,String staffCode);
}
