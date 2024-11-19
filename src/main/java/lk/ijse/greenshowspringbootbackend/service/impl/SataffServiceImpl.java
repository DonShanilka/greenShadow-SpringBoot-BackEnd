package lk.ijse.greenshowspringbootbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldStaffDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.StaffDTO;
import lk.ijse.greenshowspringbootbackend.exception.DataPersistException;
import lk.ijse.greenshowspringbootbackend.repo.FieldRepo;
import lk.ijse.greenshowspringbootbackend.repo.StaffRepo;
import lk.ijse.greenshowspringbootbackend.service.SataffService;
import lk.ijse.greenshowspringbootbackend.util.AppUtil;
import lk.ijse.greenshowspringbootbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SataffServiceImpl implements SataffService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private AppUtil appUtil;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        if (staffRepo.existsById(appUtil.generateStaffId())) {
            throw new DataPersistException((appUtil.generateStaffId()) + " - Staff already exists ");
        }
        staffRepo.save(mapping.mapStaffDtoToEntity(staffDTO));
    }

    @Override
    public void updateStaff(StaffDTO staffDTO) {

    }

    @Override
    public void deleteStaff(String staffCode) {

    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return List.of();
    }

    @Override
    public void saveFieldStaff(FieldStaffDTO fieldStaffDTO) {

    }

    @Override
    public void deleteFieldStaff(String fieldCode, String staffCode) {

    }
}
