package com.example.university2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.university2.Entity.Department;
import com.example.university2.Repository.departmentRepository;

@RestController
@RequestMapping("department")

public class DepartmentController {

    @Autowired
    departmentRepository deptRep;

    // www.mysite.com/department
    @GetMapping
    public List<Department> getDepartments() {
        return deptRep.findAll();
    }

    // www.mysite.com/department/1
    @GetMapping("{id}")
    public Optional<Department> getDepartment(@PathVariable Long id) {
        return deptRep.findById(id);
    }

    @PostMapping
    public String saveDepartment(@RequestBody Department dept) {
        deptRep.save(dept);
        return "Department saved";
    }

    @DeleteMapping("remove/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        deptRep.deleteById(id);
        return "Department deleted";
    }

}
