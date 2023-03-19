package info.mastera.repository;

import info.mastera.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByRegNumAndRegistrationDate(String regNum, LocalDateTime registrationDate);
}
