package com.example.doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
