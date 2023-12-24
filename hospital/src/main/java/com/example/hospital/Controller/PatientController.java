package com.example.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.Entity.Patient;
import com.example.hospital.Repository.PatientRepository;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientRepository patRep;

    @GetMapping
    public List<Patient> getAll() {
        return patRep.findAll();
    }

    // Get a single patient by id
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patRep.findById(id).orElse(null);
    }

    // Create a new patient
    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody Patient p) {
        if (p.getName() == null || p.getGender() == null || p.getDob() == null) {
            return new ResponseEntity<>("Missing fields", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(patRep.save(p), HttpStatus.CREATED);
    }

    // Update a patient information
    @PostMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient pDetails) {

        Patient p = patRep.findById(id).orElse(null);

        if (p != null) {
            p.setName(pDetails.getName());
            p.setDob(pDetails.getDob());

            patRep.save(p);
        }
        return p;
    }

    // Delete a patient
    @PostMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        patRep.deleteById(id);
    }
}
