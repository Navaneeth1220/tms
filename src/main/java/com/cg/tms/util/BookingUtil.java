package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.BookingDetails;
import com.cg.tms.entities.Booking;

@Component
public class BookingUtil {
	
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
	
}
