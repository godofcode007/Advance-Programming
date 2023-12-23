package com.example.univeristy4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.univeristy4.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}