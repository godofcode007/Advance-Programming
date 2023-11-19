package com.example.terminal21;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.terminal21.Entity.Bus;
import com.example.terminal21.Entity.Passenger;
import com.example.terminal21.Entity.Ticket;
import com.example.terminal21.Service.TerminalService;

@SpringBootApplication
public class Terminal21Application {

	public static void main(String[] args) {
		SpringApplication.run(Terminal21Application.class, args);
	}

	@Bean
	public CommandLineRunner cmd(TerminalService terSev) {
		return runner -> {
			useServices(terSev);
		};
	}

	private void useServices(TerminalService terSev) {
		Bus b1 = new Bus();
		b1.setModel("Benz");
		b1.setPassenger(new ArrayList<Passenger>());
		terSev.saveBus(b1);

		Bus b2 = new Bus();
		b2.setModel("BMW");
		b2.setPassenger(new ArrayList<Passenger>());
		terSev.saveBus(b2);

		Ticket t1 = new Ticket();
		t1.setDestination("Istanbul");

		Ticket t2 = new Ticket();
		t2.setDestination("London");

		Passenger p1 = new Passenger();
		p1.setName("Mohamaad");
		p1.setSurname("Rauf");
		p1.setBus(b1);
		p1.setTicket(t1);

		Passenger p2 = new Passenger();
		p2.setName("Mohamin");
		p2.setSurname("Bashir");
		p2.setBus(b2);
		p2.setTicket(t2);

		terSev.savePassenger(p1);
		terSev.savePassenger(p2);

	}

}
