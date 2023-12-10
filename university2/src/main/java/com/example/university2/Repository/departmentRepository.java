package com.example.university2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.university2.Entity.Department;

public interface departmentRepository extends JpaRepository<Department, Long> {

}
