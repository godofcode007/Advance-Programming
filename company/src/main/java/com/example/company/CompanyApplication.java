package com.example.company;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.company.Service.EmployeeService;
import com.example.company.Entity.Department;
import com.example.company.Entity.Employee;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeService empSer) {
		return runner -> {
			// newEmployee(empSer);
			// getEmployees(empSer);

			runApplication(empSer);
		};
	}

	private void runApplication(EmployeeService empSer) {
		Employee emp1 = new Employee("Mohamin", "Bashir");
		Employee emp2 = new Employee("Rauf", "Habib");
		Employee emp3 = new Employee("Dania", "Sultani");

		Department dep1 = new Department();
		dep1.setTitle("Computing");

		Department dep2 = new Department();
		dep2.setTitle("Business");

		empSer.saveDepartment(dep1);
		empSer.saveDepartment(dep2);

		emp1.setDepartment(dep1);
		emp2.setDepartment(dep1);
		emp3.setDepartment(dep2);

		empSer.saveEmployee(emp1);
		empSer.saveEmployee(emp2);
		empSer.saveEmployee(emp3);

		dep1.setEmployees(new ArrayList<Employee>());
		dep1.addEmployee(emp1);
		dep1.addEmployee(emp2);
		dep2.setEmployees(new ArrayList<Employee>());
		dep2.addEmployee(emp3);

		// empSer.getDepartments().forEach(d -> System.out.println(d.getTitle()));
		// empSer.getEmployees().forEach(
		// e -> System.out.println(e.getName() + " " + e.getSurname() + " " +
		// e.getDepartment().getTitle()));

		empSer.getEmployeeDepId((long) 2).forEach(e -> System.out.println(e.getName() + " " + e.getSurname()));
	}

	/*
	 * private void getEmployees(EmployeeService empSer) {
	 * empSer.getEmployees().forEach(e -> System.out.println(e.getName() + " " +
	 * e.getSurname()));
	 * 
	 * 
	 * above line is the same as below lines
	 * 
	 * for(Employee e : empSer.getEmployees()){
	 * System.out.println(e.getName() + " " + e.getSurname());
	 * }
	 * 
	 * }
	 * 
	 * private void newEmployee(EmployeeService empSer) {
	 * empSer.saveEmployee(new Employee("Bilal", "Mohammad"));
	 * 
	 * }
	 * 
	 */

}
