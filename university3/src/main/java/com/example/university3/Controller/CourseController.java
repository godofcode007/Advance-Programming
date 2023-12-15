package com.example.university3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university3.Entity.Course;
import com.example.university3.Repository.CourseRepository;
import com.example.university3.Repository.StudentRepository;

@RestController
@RequestMapping("courses")

public class CourseController {

    @Autowired
    CourseRepository couRep;

    @Autowired
    StudentRepository stuRep;

    @GetMapping
    public List<Course> getCourses() {
        return couRep.findAll();
    }

    // display course according to student id
    @GetMapping("student/{id}")
    public List<Course> getCoursesById(@PathVariable Long id) {
        return couRep.findByStudentsId(id);
    }

    // get two id from user and add student to course
    @PostMapping("addStudent/{couId}/{stuId}")
    public ResponseEntity<String> addStudent(@PathVariable Long couId, @PathVariable long stuId) {

        couRep.findById(couId).get().addStudent(stuRep.findById(stuId).get());
        couRep.flush();
        return ResponseEntity.ok("Student added to course");
    }

    // get two id from user and remove student from course
    @PostMapping("remove/{couId}/{stuId}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id, @PathVariable long stuId) {

        couRep.findById(id).get().removeStudent(stuRep.findById(stuId).get());
        couRep.flush();
        return ResponseEntity.ok("Student removed from course");
    }

}
