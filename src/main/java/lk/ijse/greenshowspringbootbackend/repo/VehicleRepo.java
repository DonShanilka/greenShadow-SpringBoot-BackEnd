package lk.ijse.greenshowspringbootbackend.repo;

import lk.ijse.greenshowspringbootbackend.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    @Query(value = "SELECT vehicle_code FROM vehicle WHERE vehicle_code LIKE 'V00%' ORDER BY CAST(SUBSTRING(vehicle_code, 4) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String findLastVehicleCode();
}
