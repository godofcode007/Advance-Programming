package com.example.doctor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.Entity.Doctor;
import com.example.doctor.Repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository docRep;

    public List<Doctor> findByOfficeno(Long officeno) {
        return docRep.findByOfficeno(officeno);
    }

    public void addDoctor(Doctor d) {
        docRep.save(d);
    }

    public Optional<Doctor> findById(Long id) {
        return docRep.findById(id);
    }

    public List<Doctor> findAll() {
        return docRep.findAll();
    }

}