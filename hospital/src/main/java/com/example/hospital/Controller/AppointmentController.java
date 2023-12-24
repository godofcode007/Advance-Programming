package com.example.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.Entity.Appointment;
import com.example.hospital.Repository.AppointmentRepository;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentRepository appRep;

    @GetMapping
    public List<Appointment> getAll() {
        return appRep.findAll();
    }

    // Get a single appointment by id
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appRep.findById(id).orElse(null);
    }

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(Appointment a) {
        return appRep.save(a);
    }

    // Update a appointment information
    @PostMapping("/update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, Appointment aDetails) {

        Appointment a = appRep.findById(id).orElse(null);

        if (a != null) {
            a.setPatient(aDetails.getPatient());
            a.setDoctor(aDetails.getDoctor());
            a.setAppointmentDate(aDetails.getAppointmentDate());

            appRep.save(a);
        }
        return a;
    }

    // Delete a appointment
    @PostMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appRep.deleteById(id);
    }

}
