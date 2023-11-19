package com.example.doctor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.Entity.Patient;
import com.example.doctor.Repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    PatientRepository patRep;

    public void addPatient(Patient p) {
        patRep.save(p);
    }

    public void findPatient(Long id) {
        patRep.findById(id);
    }

    public void deletePatient(Long id) {
        patRep.deleteById(id);
    }

    public void getAllPatient() {
        patRep.findAll();
    }

}
