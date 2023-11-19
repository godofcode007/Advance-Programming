package com.example.doctor.Service;

import java.util.List;

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

    public void findById(Long id) {
        docRep.findById(id);
    }

    public void findAll() {
        docRep.findAll();
    }

}
