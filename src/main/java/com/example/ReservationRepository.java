package com.example;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	@RestResource(path="find-by-rn")
	Collection<Reservation> findByReservationName(@Param("rn") String rn);
	@RestResource(path="find-by-rn-containing")
	Collection<Reservation> findByReservationNameContainingIgnoreCase(@Param("rn") String rn);
}
