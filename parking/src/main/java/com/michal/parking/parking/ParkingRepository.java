package com.michal.parking.parking;

import com.michal.parking.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Parking> findWithLockingById(int id);

}
