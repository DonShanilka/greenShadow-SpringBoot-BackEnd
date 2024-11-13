package lk.ijse.greenshowspringbootbackend.dao;

import lk.ijse.greenshowspringbootbackend.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDAO extends JpaRepository<CropEntity, String> {
    @Query(value = "SELECT * FROM crop WHERE crop_code = (SELECT crop_code FROM crop ORDER BY CAST(SUBSTRING(crop_code, 6) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    CropEntity findLastRowNative();
}
