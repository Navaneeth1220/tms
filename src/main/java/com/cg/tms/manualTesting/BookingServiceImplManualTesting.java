package com.cg.tms.manualTesting;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.PaymentDetails;
import com.cg.tms.entities.TicketDetails;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.service.IBookingService;
import com.cg.tms.service.IPackageService;

@Component
public class BookingServiceImplManualTesting {
	
	@Autowired
	private IBookingService service;
	
	@Autowired
	private IPackageService pService;
	
	public void start() {
		try {
			
			Package pack1 = new Package();
			pack1.setPackageName("Local");
			pack1.setPackageDescription("diverse and cultural");
			pack1.setPackageType("Normal");
			pack1.setPackageCost(8500.0);
			
			Hotel hotel1 = new Hotel();
			hotel1.setHotelId(177);
			hotel1.setHotelName("Guhantara");
			hotel1.setHotelDescription("Authentic and relaxing");
			hotel1.setHotelType("Three star");
			hotel1.setAddress(
					"Sy. No. 177 & 177/18, Nowkal Palya, Kaggalipura, Off Kanakapura Main Road, South, Taluk, Bengaluru, Karnataka 560082");
			hotel1.setRent(4720.0);
			hotel1.setStatus("Good");
			
			TicketDetails ticket1 = new TicketDetails();
			ticket1.setTicketId("401254");
			ticket1.setRoute(null);
			ticket1.setStatus("Processing");
			
			PaymentDetails payment1 = new PaymentDetails();
			payment1.setPaymentId(4012);
			payment1.setPaymentMode("Debit");
			payment1.setBankName("SBI");
			payment1.setCardNo(1234567891);
			payment1.setNetAmount(1000000.0);
			payment1.setPaymentStatus("Tranaction Complete");
			payment1.setUserId(21);
			Package addPackage1 = pService.addPackage(pack1);
			
			Booking book= new Booking();
			LocalDate currentDate = LocalDate.now();
			book.setBookingDate(currentDate);
			book.setBookingTitle("Goa Trip");
			book.setBookingType("Executive");
			book.setDescription("Thalaiva");
			book.setUserId(1);
			book.setPack(addPackage1);
			Booking booked=service.makeBooking(book);
			System.out.println("Booking made");
			display(booked);	
			
			Booking book1 = new Booking();
			book1.setBookingDate(currentDate);
			book1.setBookingTitle("Goa Trip");
			book1.setBookingType("Executive");
			book1.setUserId(2);
			book1.setPack(addPackage1);
			Booking booked1=service.makeBooking(book1);
			display(booked1);
			
			System.out.println("Display all bookings");
			List<Booking> bookings=service.viewAllBookings();
			displayAll(bookings);
			
			Booking fetched = service.viewBooking(book.getBookingId());
			System.out.println("Fetched Booking");
			display(fetched);
			
			//Booking deletedBooking = service.cancelBooking(book1.getBookingId());
			//System.out.println("Deleted booking");
			//display(deletedBooking);
		}
		catch(BookingNotFoundException e) {
			System.out.println("Booking not found");
		}
		catch(InvalidIdException e) {
			System.out.print("ID exception");
	
		}
		catch(InvalidBookingException e) {
			System.out.println("Booking exception");

		}
	}

	 void display(Booking booked) {
		System.out.println(booked.getBookingId()+" "+booked.getBookingType()+" "+booked.getBookingTitle()
							+" "+booked.getUserId()+" "+booked.getBookingDate()+" "+booked.getPack().getPackageId()
							+" "+booked.getPack().getPackageName());
		
	}
	 
	 void displayAll(Collection<Booking> bookings) {
		 for(Booking book : bookings) {
			 display(book);
		 }
	 }
}
