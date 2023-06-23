package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Doctor;
import com.lekarze.visit_api.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAllByDeletedIsFalse();
    }
    @Override
    public Doctor findById(int id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor id=" + id + " not found"));
    }
    @Override
    public Doctor findWithLockingById(int id) {
        return doctorRepository.findWithLockingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor id=" + id + " not found"));
    }
    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @Override
    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
}
