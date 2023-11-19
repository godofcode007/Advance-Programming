package com.example.doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.doctor.Entity.Doctor;
import com.example.doctor.Entity.Patient;
import com.example.doctor.Service.DoctorService;
import com.example.doctor.Service.PatientService;

@SpringBootApplication
public class DoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(DoctorService docSer, PatientService patSer) {
		return userservice -> {
			Doctor d1 = new Doctor();
			d1.setName("John");
			d1.setSurname("Doe");
			d1.setOffice_no(1L);
			docSer.addDoctor(d1);

			Doctor d2 = new Doctor();
			d2.setName("Kane");
			d2.setSurname("Joe");
			d2.setOffice_no(2L);
			docSer.addDoctor(d2);

			Patient p1 = new Patient();
			p1.setName("Arrick");
			p1.setSurname("Kon");
			p1.setDisease("Covid");
			p1.setDoctor(d1);
			patSer.addPatient(p1);

			Patient p2 = new Patient();
			p2.setName("Barrick");
			p2.setSurname("Kon");
			p2.setDisease("Covid");
			p2.setDoctor(d2);
			patSer.addPatient(p2);

		};
	}

}
