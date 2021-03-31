package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.tms.dto.BookedPackageDetails;
import com.cg.tms.dto.CreateBookingRequest;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;
import com.cg.tms.service.IPackageService;
import com.cg.tms.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.dto.BookingDetails;


@Component
public class BookingUtil {

	@Autowired
	private IPackageService packageService;
	@Autowired
	private IRouteService routeService;

	public Booking toBookingEntity(CreateBookingRequest requestData){
		Booking booking = new Booking();
		booking.setBookingTitle(requestData.getBookingTitle());
		booking.setBookingType(requestData.getBookingType());
		booking.setDescription(requestData.getDescription());
		booking.setUserId(requestData.getUserId());
		Package pack=packageService.searchPackage(requestData.getPackageId());
		booking.setPack(pack);
		PaymentDetails payment=new PaymentDetails();
		payment.setUserId(requestData.getUserId());
		payment.setBankName(requestData.getBankName());
		payment.setCardNo(requestData.getCardNo());
		booking.setPayment(payment);
		Route route=routeService.searchRoute(requestData.getRouteId());
		TicketDetails ticket=new  TicketDetails();
		ticket.setRoute(route);
		booking.setTicket(ticket);
		return booking;
	}


	public BookingDetails toBookingDetails(Booking book) {
		BookingDetails details = new BookingDetails();
		details.setBookingId(book.getBookingId());
		details.setBookingTitle(book.getBookingTitle());
		details.setBookingType(book.getBookingType());
		details.setDescription(book.getDescription());
		details.setUserId(book.getUserId());
		return details;
	}

	public List<BookingDetails> toBookingDetails(Collection<Booking> bookings){
		List<BookingDetails> books = new ArrayList<>();
		for(Booking book : bookings) {
			BookingDetails booked = toBookingDetails(book);
			books.add(booked);
		}

		return books;
	}

	public BookedPackageDetails toPackageDetails(Package pack) {
		BookedPackageDetails desired = new BookedPackageDetails();
		desired.setPackageId(pack.getPackageId());
		desired.setPackageCost(pack.getPackageCost());
		desired.setPackageDescription(pack.getPackageDescription());
		desired.setPackageName(pack.getPackageName());
		desired.setPackageType(pack.getPackageType());
		return desired;
	}

}