package com.example.terminal_2;

import java.util.ArrayList;

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

		Bus b1 = new Bus();
		b1.setModel("Benz");
		b1.setPassengers(new ArrayList<Passenger>());
		terSer.saveBus(b1);

		Bus b2 = new Bus();
		b2.setModel("BMW");
		b2.setPassengers(new ArrayList<Passenger>());
		terSer.saveBus(b2);

		Passenger p1 = new Passenger();
		p1.setName("Mohammad");
		p1.setSurname("Rauf");
		p1.setBus(b1);

		Passenger p2 = new Passenger();
		p2.setName("Yousef");
		p2.setSurname("AboIsmail");
		p1.setBus(b2);

		terSer.savePassenger(p1);
		terSer.savePassenger(p2);

		System.out.println("Buses: ");
		terSer.getBuses().forEach(System.out::println);

		System.out.println("Passengers: ");
		terSer.getPassengers().forEach(System.out::println);

	}

}
