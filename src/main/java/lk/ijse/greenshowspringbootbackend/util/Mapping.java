package lk.ijse.greenshowspringbootbackend.util;

import lk.ijse.greenshowspringbootbackend.dto.impl.*;
import lk.ijse.greenshowspringbootbackend.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

//    for crop mapping
public Field mapFieldDtoToEntity(FieldDTO fieldDTO) {
    return modelMapper.map(fieldDTO, Field.class);
}
    public List<FieldDTO> mapFieldEntitiesToDtos(List<Field> fieldEntities) {
        return modelMapper.map(fieldEntities, new TypeToken<List<FieldDTO>>() {}.getType());
    }

    public Crop mapCropDtoToEntity(CropDTO cropDTO) {
        return modelMapper.map(cropDTO, Crop.class);
    }

    public List<CropDTO> mapCropEntitiesToDtos(List<Crop> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDTO>>() {}.getType());
    }

    public Log mapLogDtoToEntity(LogDTO logDTO) {
        return modelMapper.map(logDTO, Log.class);
    }

    public List<LogDTO> mapLogEntitiesToDtos(List<Log> logEntities) {
        return modelMapper.map(logEntities, new TypeToken<List<LogDTO>>() {}.getType());
    }

    public Staff mapStaffDtoToEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, Staff.class);
    }

    public List<StaffDTO> mapStaffEntitiesToDtos(List<Staff> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>() {}.getType());
    }

    public Vehicle mapVehicleDtoToEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    public Equipment mapEquipmentDtoToEntity(EquipmentDTO equipmentDTO) {
        return modelMapper.map(equipmentDTO, Equipment.class);
    }

    public List<EquipmentDTO> mapEquipmentEntitiesToDtos(List<Equipment> equipmentEntities) {
        return modelMapper.map(equipmentEntities, new TypeToken<List<EquipmentDTO>>() {}.getType());
    }

    public List<VehicleDTO> mapVehicleEntitiesToDtos(List<Vehicle> vehicleEntities) {
        return modelMapper.map(vehicleEntities, new TypeToken<List<VehicleDTO>>() {}.getType());
    }
}
