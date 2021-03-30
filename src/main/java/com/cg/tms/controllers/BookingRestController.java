package com.cg.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.BookingDetails;
import com.cg.tms.dto.CreateBookingRequest;
import com.cg.tms.dto.DeleteBookingRequest;
import com.cg.tms.entities.Booking;
import com.cg.tms.service.IBookingService;
import com.cg.tms.util.BookingUtil;

@RequestMapping("/book")
@RestController
public class BookingRestController {
	
	@Autowired
	private IBookingService service;
	
	@Autowired
	private BookingUtil util;
	
	@PostMapping("/add")
	public BookingDetails makeBooking(@RequestBody CreateBookingRequest requestData) {
		Booking book = new Booking();
		book.setBookingTitle(requestData.getBookingTitle());
		book.setBookingType(requestData.getBookingType());
		book.setDescription(requestData.getDescription());
		book.setUserId(requestData.getUserId());
		Booking booked = service.makeBooking(book);
		BookingDetails details = util.toBookingDetails(booked);
		return details;
	}
	
	@GetMapping("/byid/{id}")
	public BookingDetails findBooking(@PathVariable("id") int id) {
		Booking book = service.viewBooking(id);
		BookingDetails fetched = util.toBookingDetails(book);
		return fetched;
	}
	
	@GetMapping
	public List<BookingDetails> allBookings(){
		List<Booking> booking = service.viewAllBookings();
		List<BookingDetails> bookings = util.toBookingDetails(booking);
		return bookings;
	}
	
	@DeleteMapping("/delete")
	public void deleteBooking(@RequestBody DeleteBookingRequest requestData) {
		service.cancelBooking(requestData.getId());	
		//return "Booking delete for id "+requestData.getId();
	}
	
	
}
