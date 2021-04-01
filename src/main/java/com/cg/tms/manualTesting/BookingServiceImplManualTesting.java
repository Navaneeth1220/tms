package com.cg.tms.manualTesting;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;
import com.cg.tms.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@Autowired
	private IRouteRepository routeRepository;

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
			pack1.setHotel(hotel1);


			Route route = new Route();
			route.setRouteId("37fry");
			route=routeRepository.save(route);
			Package addPackage1 = pService.addPackage(pack1);
			TicketDetails ticket1 = new TicketDetails();
			ticket1.setTicketId("401254");
			ticket1.setRoute(route);
			ticket1.setStatus("Processing");

			PaymentDetails paymentDetails1=new PaymentDetails();

			Booking book1= new Booking();
			LocalDate currentDate = LocalDate.now();
			book1.setBookingDate(currentDate);
			book1.setBookingTitle("Goa Trip");
			book1.setBookingType("Executive");
			book1.setDescription("Thalaiva");
			book1.setUserId(1);
			book1.setPack(addPackage1);
			book1.setPayment(paymentDetails1);
            book1.setTicket(ticket1);
			Booking booked=service.makeBooking(book1);
			System.out.println("Booking made");
			display(booked);


			TicketDetails ticket2 = new TicketDetails();
			ticket2.setTicketId("8771254");
			ticket2.setRoute(route);
			ticket2.setStatus("Processing");


			PaymentDetails paymentDetails2=new PaymentDetails();
			Booking book2 = new Booking();
			book2.setBookingDate(currentDate);
			book2.setBookingTitle("Goa Trip");
			book2.setBookingType("Executive");
			book2.setUserId(2);
			book2.setPack(addPackage1);
			book2.setPayment(paymentDetails2);
			book2.setTicket(ticket2);
			Booking booked1=service.makeBooking(book2);
			display(booked1);
			
			System.out.println("Display all bookings");
			List<Booking> bookings=service.viewAllBookings();
			displayAll(bookings);
			
			Booking fetched = service.viewBooking(book1.getBookingId());
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
