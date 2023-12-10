package com.example.university2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.university2.Entity.Student;
import com.example.university2.Repository.departmentRepository;
import com.example.university2.Repository.studentRepository;

public class StudentController {

    @Autowired
    studentRepository stuRepo;

    @Autowired
    departmentRepository deptRepo;

    @GetMapping
    public List<Student> getStudents() {
        return stuRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return stuRepo.findById(id);
    }

    @PostMapping("save/{id}")
    public String saveStudent(@RequestBody Student stu, @PathVariable Long id) {
        stu.setDept(deptRepo.findById(id).get());
        stuRepo.save(stu);
        return "Student saved";
    }

}
