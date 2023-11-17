package com.example.terminal_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.terminal_2.Entity.Bus;
import com.example.terminal_2.Entity.Passenger;
import com.example.terminal_2.Service.TerminalService;

@SpringBootApplication
public class Terminal2Application {

	public static void main(String[] args) {
		SpringApplication.run(Terminal2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TerminalService terSer) {
		return runner -> {
			runApplication(terSer);
		};
	}

	private void runApplication(TerminalService terSer) {
		Bus b1 = new Bus("Mercedes");
		Bus b2 = new Bus("BMW");

		Passenger p1 = new Passenger("John", "Doe");
		Passenger p2 = new Passenger("Jane", "dog");
		Passenger p3= new Passenger("June", "fog");

		b1.addPassenger(p1);
		b1.addPassenger(p2);
		b2.addPassenger(p3);

		terSer.saveBus(b1);
		terSer.saveBus(b2);


		
	}

}
