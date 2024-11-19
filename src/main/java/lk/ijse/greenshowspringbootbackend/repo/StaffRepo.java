package lk.ijse.greenshowspringbootbackend.repo;

import lk.ijse.greenshowspringbootbackend.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepo extends JpaRepository<Staff, String> {
    @Query(value = "SELECT staff_id FROM staff WHERE staff_id LIKE 'S00%' ORDER BY CAST(SUBSTRING(staff_id, 4) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String findLastStaffCode();
}
