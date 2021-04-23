package com.cg.tms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.PaymentDetails;
import com.cg.tms.entities.TicketDetails;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.repository.IBookingRepository;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.repository.IPaymentDetailsRepository;
import com.cg.tms.repository.ITicketDetailsRepository;

@Service
public class BookingServiceImpl extends BaseService implements IBookingService {

	@Autowired
	private IBookingRepository repo;

	@Autowired
	private IPaymentDetailsRepository paymentRepository;

	@Autowired
	private ITicketDetailsRepository ticketRepository;

	
	/**
	 * scenario: to make a booking and save it in database input : a Booking object
	 * and is validated is using validateBooking() method expectation : all values
	 * to be saved in the database
	 */
	@Transactional
	@Override
	public Booking makeBooking(Booking booking) {
		validateBooking(booking);
		booking.setBookingDate(currentDate());

		String ticketId = generateId();
		TicketDetails ticket = booking.getTicket();
		ticket.setStatus("reserved");
		ticket.setTicketId(ticketId);

		ticket = ticketRepository.save(ticket);
		booking.setTicket(ticket);

		PaymentDetails payment = booking.getPayment();
		payment = paymentRepository.save(payment);
		booking.setPayment(payment);
		return repo.save(booking);
		//return booking;
	}

	public LocalDate currentDate() {
		return LocalDate.now();
	}

	/**
	 * scenario : cancel booking using booking id input : booking id of the booking
	 * made expectation : the booking is cancelled and deleted from the database
	 */
	@Transactional
	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		validateId(bookingId);
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		Booking fetched = optional.get();
		repo.delete(fetched);
		return fetched;
	}

	/**
	 * scenario : to view the current booking made input : booking id of the booking
	 * made expectation : the values of the booking are retrieved from database
	 */
	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return optional.get();
	}

	/**
	 * scenario : to view all the bookings expectation : list of all bookings are
	 * fetched
	 */
	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = repo.findAll();
		return bookings;
	}
	
	@Override
	public List<Booking> viewBookingByUserId(int userId){
		List<Booking> bookings = repo.findByUserId(userId);
		return bookings;
	}

	void validateBooking(Booking booking) {
		validateId(booking.getBookingId());
		validateBookingType(booking.getBookingTitle());
		validateBookingTitle(booking.getBookingTitle());
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidIdException("ID cannot be negative");
		}
	}

	void validateBookingType(String type) {
		if (type == null || type.isEmpty() || type.trim().isEmpty()) {
			throw new InvalidBookingException("Check Booking type");
		}
	}

	void validateBookingTitle(String title) {
		if (title == null || title.isEmpty() || title.trim().isEmpty()) {
			throw new InvalidBookingException("Check Booking title");
		}
	}

}
