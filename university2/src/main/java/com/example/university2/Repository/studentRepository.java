package com.example.university2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university2.Entity.Student;

public interface studentRepository extends JpaRepository<Student, Long> {

}
