package lk.ijse.greenshowspringbootbackend.util;

import lk.ijse.greenshowspringbootbackend.dto.impl.CropDTO;
import lk.ijse.greenshowspringbootbackend.dto.impl.FieldDTO;
import lk.ijse.greenshowspringbootbackend.entity.impl.Crop;
import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
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
    public Crop toCropEntity(CropDTO cropDTO) {
        return modelMapper.map(cropDTO, Crop.class);
    }
    public CropDTO toCropDTO(Crop cropEntity) {
        return modelMapper.map(cropEntity, CropDTO.class);
    }
    public List<CropDTO> cropDTOList(List<Crop> cropEntityList) {
        return modelMapper.map(cropEntityList, new TypeToken<List<CropDTO>>() {}.getType());
    }

    // for Field mapping
    public Field toFieldEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO, Field.class);
    }
    public FieldDTO toFieldDTO(Field fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public List<FieldDTO> cropFieldList(List<Field> fieldEntityList) {
        return modelMapper.map(fieldEntityList, new TypeToken<List<FieldDTO>>() {}.getType());
    }
}
