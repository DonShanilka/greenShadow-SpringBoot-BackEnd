package lk.ijse.greenshowspringbootbackend.dao;

import lk.ijse.greenshowspringbootbackend.entity.impl.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDAO extends JpaRepository<Equipment,String> {

}
