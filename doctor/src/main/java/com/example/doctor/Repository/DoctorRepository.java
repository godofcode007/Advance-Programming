package com.example.doctor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
List<Doctor> findByOfficeno(Long officeno);
}
