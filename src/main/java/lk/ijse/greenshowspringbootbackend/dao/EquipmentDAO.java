package lk.ijse.greenshowspringbootbackend.dao;

import lk.ijse.greenshowspringbootbackend.entity.impl.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDAO extends JpaRepository<EquipmentEntity,String> {

}
