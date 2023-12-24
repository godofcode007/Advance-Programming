package com.example.hospital.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.Entity.Doctor;
import com.example.hospital.Repository.DoctorRepository;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorRepository docRep;

    @GetMapping
    public List<Doctor> getAll() {
        return docRep.findAll();
    }

    // Get a single doctor by id
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return docRep.findById(id).orElse(null);
    }

    // Create a new doctor
    @PostMapping
    public Doctor createDoctor(Doctor d) {
        return docRep.save(d);
    }

    // Update a doctor information
    @PostMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Long id, Doctor dDetails) {

        Doctor d = docRep.findById(id).orElse(null);

        if (d != null) {
            d.setName(dDetails.getName());
            d.setSpecialty(dDetails.getSpecialty());

            docRep.save(d);
        }
        return d;
    }

    // Delete a doctor
    @PostMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        docRep.deleteById(id);
    }

}
