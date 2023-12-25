package com.example.hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.Entity.Appointment;
import com.example.hospital.Repository.AppointmentRepository;
import com.example.hospital.Repository.DoctorRepository;
import com.example.hospital.Repository.PatientRepository;
import com.example.hospital.Service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentRepository appRep;

    @Autowired
    DoctorRepository docRep;

    @Autowired
    PatientRepository patRep;

    @Autowired
    AppointmentService appSer;

    @GetMapping

    public String getAll() {
        String result = "";

        for (Appointment a : appRep.findAll()) {
            result += "ID: " + a.getId() + " | " + "Patient: " + a.getPatient().getName() + " | " + "Doctor: "
                    + a.getDoctor().getName() + " | " + "Appointment Date: " + a.getAppointmentDate()
                    + " | " + " Appointment Time: " + a.getAppointmentTime() + " | " + " Details : " + a.getDetails()
                    + "<br>";
        }

        return result;
    }

    // Get a single appointment by id
    @GetMapping("/{id}")
    public String getAppointmentById(@PathVariable Long id) {
        String result = "";

        Appointment a = appRep.findById(id).orElse(null);

        if (a != null) {
            result += "ID: " + a.getId() + " | " + "Patient: " + a.getPatient().getName() + " | " + "Doctor: "
                    + a.getDoctor().getName() + " | " + "Appointment Date: " + a.getAppointmentDate()
                    + " | " + " Appointment Time: " + a.getAppointmentTime() + " | " + " Details : " + a.getDetails()
                    + "<br>";
        }
        return result;
    }

    @PostMapping("/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appRep.save(appointment);
    }

    // public Appointment addAppointment(@RequestBody Map<String, String> body) {
    // String appointmentDate = body.get("appointmentDate");
    // String appointmentTime = body.get("appointmentTime");
    // String details = body.get("details");
    // Long patientId = Long.parseLong(body.get("patientId"));
    // Long doctorId = Long.parseLong(body.get("doctorId"));

    // Patient patient = patRep.findById(patientId).get();
    // Doctor doctor = docRep.findById(doctorId).get();

    // Appointment appointment = new Appointment();
    // appointment.setAppointmentDate(appointmentDate);
    // appointment.setAppointmentTime(appointmentTime);
    // appointment.setDetails(details);
    // appointment.setPatient(patient);
    // appointment.setDoctor(doctor);

    // return appRep.save(appointment);
    // }

    // Update a appointment information
    @PostMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment aDetails) {
        Appointment a = appRep.findById(id).orElse(null);

        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        a.setPatient(aDetails.getPatient());
        a.setDoctor(aDetails.getDoctor());
        a.setDetails(aDetails.getDetails());
        a.setAppointmentDate(aDetails.getAppointmentDate());
        a.setAppointmentTime(aDetails.getAppointmentTime());

        final Appointment updatedAppointment = appRep.save(a);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    // Delete a appointment
    // i use cascade so that why we need to make another method inside the patient
    // and doctor entity to make it null before deleting the appointment even i use
    // Service with @Transactional annotation and custon delete method
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id) {
        return appRep.findById(id).map(appointment -> {
            appointment.getPatient().removeAppointment(appointment);
            appointment.getDoctor().removeAppointment(appointment);
            appRep.delete(appointment);
            return ResponseEntity.ok().build();
        }).orElseThrow();
    }
}
