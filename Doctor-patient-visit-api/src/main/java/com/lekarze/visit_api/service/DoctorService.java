package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Doctor;

import java.util.List;


public interface DoctorService {


    List<Doctor> findAll();

    Doctor findById(int id);

    Doctor findWithLockingById(int id);

    Doctor save(Doctor doctor);

    void delete(int id);

}
