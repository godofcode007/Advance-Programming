package com.example.univeristy4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.univeristy4.Entity.Course;
import com.example.univeristy4.Entity.Registration;
import com.example.univeristy4.Repository.CourseRepository;
import com.example.univeristy4.Repository.RegistrationRepository;
import com.example.univeristy4.Repository.StudentRepository;

@RestController
@RequestMapping("reg")
public class RegistrationController {

    @Autowired
    RegistrationRepository regRep;

    @Autowired
    CourseRepository couRep;

    @Autowired
    StudentRepository stuRep;

    // printing like that "Design" as course "computing" as a department and "John"
    // as a name "wick" as a surname and grade as 90. how can i do that?
    @GetMapping("courses")
    public String getCourses() {
        String result = "";

        for (Course c : couRep.findAll()) {
            result += c.getTitle() + " " + c.getDepartment() + "<br>";

            for (Registration r : c.getRegistrations()) {
                result += r.getStudent().getName() + " " + r.getStudent().getSurname() + " " + r.getGrade() + "<br>";
            }

            result += "<br>";
        }
        return result;
    }

    @GetMapping("/{courID}/{stuID}/{grade}")
    public ResponseEntity<String> addRegister(@PathVariable Long courID, @PathVariable Long stuID,
            @PathVariable int grade) {
        Registration reg = new Registration();
        reg.setCourse(couRep.findById(courID).get());
        reg.setStudent(stuRep.findById(stuID).get());
        reg.setGrade(grade);

        stuRep.flush();
        couRep.flush();
        regRep.save(reg);

        return ResponseEntity.ok("Registration added");
    }

}
