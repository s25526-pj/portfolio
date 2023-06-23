package com.lekarze.visit_api.repository;

import com.lekarze.visit_api.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllByDeletedIsFalse();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    Optional<Patient> findWithLockingById(int id);
}
