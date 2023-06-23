package com.michal.parking.car;

import com.michal.parking.car.model.Car;
import com.michal.parking.common.CarException;
import com.michal.parking.common.ParkingException;
import com.michal.parking.parking.ParkingService;
import com.michal.parking.parking.model.Parking;
import com.michal.parking.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final TicketService ticketService;
    private final ParkingService parkingService;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car id=" + id + " not found"));
    }

    public Car findWithLockingById(int id) {
        return carRepository.findWithLockingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car id=" + id + " not found"));
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public void park(int carId, int parkingId) {
        Car car = findWithLockingById(carId);
        Parking parking = parkingService.findWithLockingById(parkingId);
        if (car.getParking() != null) {
            throw new CarException("This car is allready parked");
        }
        if (parking.getCars().size() == parking.getCapacity()) {
            throw new ParkingException("Parking is full");
        }
        car.setParking(parking);
        parking.getCars().add(car);
        ticketService.save(car, parking);
    }


    @Transactional
    public void leaveParking(int carId) {
        Car car = findById(carId);
        Parking parking = car.getParking();
        if (car.getParking() == null) {
            throw new ParkingException("This car is not parked anywhere");
        }
        car.setParking(null);
        carRepository.leaveParking(carId);
        parking.getCars().remove(car);
        ticketService.leaveParking(car);
    }
}
