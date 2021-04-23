package com.cg.tms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Booking;

import java.time.LocalDate;
import java.util.List;

public interface IBookingRepository extends JpaRepository<Booking,Integer>   {
	

    List<Booking>findByBookingDate(LocalDate date);

    List<Booking>findByUserId(int userId);
	
}
