package lk.ijse.greenshowspringbootbackend.dao;

import lk.ijse.greenshowspringbootbackend.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDAO extends JpaRepository<Field, String> {
}
