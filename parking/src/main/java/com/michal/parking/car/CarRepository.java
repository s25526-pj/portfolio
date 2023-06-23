package com.michal.parking.car;

import com.michal.parking.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Integer> {

    @Transactional
    @Modifying
    @Query("update Car c set c.parking = NULL where c.id = :carId")
    void leaveParking(@Param("carId") int carId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Car> findWithLockingById(int id);
}
