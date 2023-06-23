package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Patient;

import java.util.List;


public interface PatientService {


    List<Patient> findAll();

    Patient findById(int id);

    Patient findWithLockingById(int id);

    Patient save(Patient patient);

    void delete(int id);

}
