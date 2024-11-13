package lk.ijse.greenshowspringbootbackend.dao;

import lk.ijse.greenshowspringbootbackend.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CropDAO extends JpaRepository<CropEntity, String> {
}
