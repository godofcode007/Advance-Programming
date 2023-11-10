package com.example.company.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.Repository.DepartmentRepository;
import com.example.company.Repository.EmployeeRepository;
import com.example.company.Entity.Department;
import com.example.company.Entity.Employee;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRep;

    @Autowired
    DepartmentRepository depRep;
    /*
     * the autowired just do the same thing like below function!
     * 
     * public EmployeeService(EmployeeRepository empRep) {
     * this.empRep = empRep;
     * }
     */

    public void saveDepartment(Department d) {
        depRep.save(d);
    }

    public List<Department> getDepartments() {
        return depRep.findAll();
    }

    public Optional<Department> getDepartment(Long id) {
        return depRep.findById(id);
    }

    public void saveEmployee(Employee e) {
        empRep.save(e);
    }

    public List<Employee> getEmployeeDepId(Long id) {
        return empRep.findByDepartmentId(id);
    }

    public List<Employee> getEmployees() {
        return empRep.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return empRep.findById(id);
    }

    public void deleteEmployee(Long id) {
        empRep.deleteById(id);
    }
}
