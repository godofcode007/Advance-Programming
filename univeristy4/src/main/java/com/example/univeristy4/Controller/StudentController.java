package com.example.univeristy4.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.univeristy4.Repository.StudentRepository;
import com.example.univeristy4.Entity.Student;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentRepository stuRep;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = stuRep.findAll();
        students.forEach(student -> System.out.println(student)); // print each student
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // @GetMapping
    // public String getAllStudents() {
    // String result = "";
    // for (Student s : stuRep.findAll()) {
    // result += s.getName() + " " + s.getSurname() + "<br>";
    // result += "<br>";
    // }
    // return result;
    // }

    @GetMapping("{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return stuRep.findById(id);
    }

}
