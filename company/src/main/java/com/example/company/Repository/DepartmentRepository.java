package com.example.company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
