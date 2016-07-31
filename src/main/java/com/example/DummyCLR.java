package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyCLR implements CommandLineRunner {

	private ReservationRepository reservationRepository;

	@Autowired
	public DummyCLR(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Josh","Jane","Joan","Jess","Jenn","Jeff","Joel","John","Joni","Jack")
			.forEach( name -> reservationRepository.save(new Reservation(name)));
		reservationRepository.findAll().forEach(System.out::println);
	}

}
