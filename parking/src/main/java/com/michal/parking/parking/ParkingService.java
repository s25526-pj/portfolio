package com.michal.parking.parking;

import com.michal.parking.parking.model.Parking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    public Parking findById(int id) {
        return parkingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parking id=" + id + " not found"));
    }

    public Parking findWithLockingById(int id) {
        return parkingRepository.findWithLockingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parking id=" + id + " not found"));
    }

    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }



}
