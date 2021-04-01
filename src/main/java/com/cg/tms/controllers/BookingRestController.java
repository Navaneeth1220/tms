package com.cg.tms.controllers;

import java.util.List;

import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;
import com.cg.tms.service.IPackageService;
import com.cg.tms.service.IRouteService;
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
import com.cg.tms.dto.BookedPackageDetails;
import com.cg.tms.service.IBookingService;
import com.cg.tms.util.BookingUtil;

@RequestMapping("/bookings")
@RestController
public class BookingRestController {

	@Autowired
	private IBookingService service;

	private IPackageService packageService;

	private IRouteService routeService;

	@Autowired
	private BookingUtil util;

	/**
	 * method to make a new booking
	 * @param requestData
	 * @return details of the new booking made
	 */
	@PostMapping("/add")
	public BookingDetails makeBooking(@RequestBody CreateBookingRequest requestData) {
		Booking booking=util.toBookingEntity(requestData);
		Booking booked = service.makeBooking(booking);
		BookingDetails details = util.toBookingDetails(booked);
		return details;
	}

	/**
	 * method to view booking fetched by the given id
	 * @param id of the booking made
	 * @return booking details of the given id
	 */
	@GetMapping("/byid/{id}")
	public BookingDetails findBooking(@PathVariable("id") int id) {
		Booking book = service.viewBooking(id);
		BookingDetails fetched = util.toBookingDetails(book);
		return fetched;
	}

	/**
	 * method to view details of all the bookings made
	 * @return details of all the bookings made
	 */
	@GetMapping
	public List<BookingDetails> allBookings(){
		List<Booking> booking = service.viewAllBookings();
		List<BookingDetails> bookings = util.toBookingDetails(booking);
		return bookings;
	}

	/**
	 * method to delete a existing booking, delete is done by providing id
	 * @param requestData
	 */
	@DeleteMapping("/delete")
	public void deleteBooking(@RequestBody DeleteBookingRequest requestData) {
		service.cancelBooking(requestData.getId());
	}

	/**
	 * method to view the package details of the booking made
	 * @param id
	 * @return
	 */
	@GetMapping("/package/byid/{id}")
	public BookedPackageDetails viewPackage(@PathVariable("id") int id) {
		Booking book = service.viewBooking(id);
		Package pack = book.getPack();
		BookedPackageDetails fetched = util.toPackageDetails(pack);
		return fetched;
	}
}