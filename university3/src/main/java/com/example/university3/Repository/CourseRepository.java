package com.example.university3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university3.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByStudentsId(Long id);
}
