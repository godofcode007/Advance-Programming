package com.example.university3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university3.Entity.Student;
import com.example.university3.Repository.StudentRepository;

@RestController
@RequestMapping("students")

public class StudentController {

    @Autowired
    StudentRepository stuRep;

    @GetMapping
    public List<Student> getStudents() {
        return stuRep.findAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return stuRep.findById(id);
    }

    @GetMapping("course/{id}")
    public List<Student> getStudentsByCourse(@PathVariable Long id) {
        return stuRep.findByCoursesId(id);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student s) {
        return ResponseEntity.ok(stuRep.save(s));
    }

}
