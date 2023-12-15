package com.example.university3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university3.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByCoursesId(Long id);

}
