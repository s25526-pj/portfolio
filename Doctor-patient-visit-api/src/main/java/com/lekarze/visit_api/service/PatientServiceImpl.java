package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Patient;
import com.lekarze.visit_api.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAllByDeletedIsFalse();
    }
    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient id=" + id + " not found"));
    }
    @Override
    public Patient findWithLockingById(int id) {
        return patientRepository.findWithLockingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient id=" + id + " not found"));
    }
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public void delete(int id) {
        patientRepository.deleteById(id);
    }
}
