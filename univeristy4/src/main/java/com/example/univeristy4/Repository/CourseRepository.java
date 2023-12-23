package com.example.univeristy4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.univeristy4.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
