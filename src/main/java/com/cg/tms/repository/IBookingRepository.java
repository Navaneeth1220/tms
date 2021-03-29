package com.cg.tms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking,Integer>   {
	
	
	
}
