package com.cg.tms.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.PaymentDetails;
import com.cg.tms.entities.TicketDetails;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.repository.IBookingRepository;
import com.cg.tms.repository.IPaymentDetailsRepository;
import com.cg.tms.repository.ITicketDetailsRepository;

import sun.security.krb5.internal.Ticket;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplUnitTest {

	@Mock
	IBookingRepository repo;

	@Mock
	ITicketDetailsRepository ticketRepository;
	
	@Mock
	IPaymentDetailsRepository paymentRepository;

	@Spy
	@InjectMocks
	BookingServiceImpl service;

	/**
	 * Scenario Successful booking Testcase
	 */
	@Test
	void testMake_1() {
		String ticketId="dads";
		String status="reserved";
		Booking book = mock(Booking.class);
		book.setBookingDate(LocalDate.now());
		doNothing().when(service).validateBooking(book);
		when(service.generateId()).thenReturn(ticketId);
		
		TicketDetails ticket =book.getTicket();
		ticket.setStatus(status);
		ticket.setTicketId(ticketId);
		
		when(ticketRepository.save(ticket)).thenReturn(ticket);
		book.setTicket(ticket);
		
		
		PaymentDetails payment = book.getPayment();
		when(paymentRepository.save(payment)).thenReturn(payment);
		book.setPayment(payment);
		
		when(repo.save(book)).thenReturn(book);
		Booking result = service.makeBooking(book);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result,book);
		verify(repo).save(book);
		
	}

	/**
	 * scenario id cannot be negative testcase
	 */
	@Test
	void testMake_2() {
		int userId = -1;
		Booking book = mock(Booking.class);
		book.setUserId(userId);
		doThrow(InvalidIdException.class).when(service).validateBooking(book);
		Executable executable = () -> service.makeBooking(book);
		Assertions.assertThrows(InvalidIdException.class, executable);
		verify(repo, never()).save(book);
	}

	/**
	 * scenario booking type cannot be null
	 */
	@Test
	void testMake_3() {
		String bookingType = "";
		Booking book = mock(Booking.class);
		book.setBookingType(bookingType);
		doThrow(InvalidBookingException.class).when(service).validateBooking(book);
		Executable executable = () -> service.makeBooking(book);
		Assertions.assertThrows(InvalidBookingException.class, executable);
		verify(repo, never()).save(book);

	}

	/**
	 * Scenario booking title cannot be null
	 */
	@Test
	void testMake_4() {
		String bookingTitle = "";
		Booking book = mock(Booking.class);
		book.setBookingTitle(bookingTitle);
		Executable executable = () -> service.makeBooking(book);
		doThrow(InvalidBookingException.class).when(service).validateBooking(book);
		Assertions.assertThrows(InvalidBookingException.class, executable);
		verify(repo, never()).save(book);

	}

	// Booking Found
	@Test
	void testFind_1() {
		int id = 1;
		Booking book = mock(Booking.class);
		Optional<Booking> optional = Optional.of(book);
		when(repo.findById(id)).thenReturn(optional);
		Booking result = service.viewBooking(id);
		Assertions.assertEquals(result, book);
		verify(repo).findById(id);
	}

	/**
	 * Scenario Booking is not found
	 */
	@Test
	void testFind_2() {
		int id = 12;
		Optional<Booking> optional = Optional.empty();
		when(repo.findById(id)).thenReturn(optional);
		Executable executable = () -> service.viewBooking(id);
		Assertions.assertThrows(BookingNotFoundException.class, executable);
	}

	/**
	 * Deleting success scenario
	 */

	@Test
	void deleteBookingTest_1() {
		int id = 1;
		Booking book = mock(Booking.class);
		Optional<Booking> optional = Optional.of(book);
		Mockito.when(repo.findById(id)).thenReturn(optional);
		// Mockito.when(repo.delete(book)).thenReturn(Optional.empty());
		doNothing().when(service).validateId(id);
		doNothing().when(repo).delete(book);
		Booking result = service.cancelBooking(id);
		Assertions.assertNotNull(optional);
		Assertions.assertEquals(book, result);
		verify(repo).delete(result);
	}

	/**
	 * Scenario id not found for deleting. Delete failed
	 */
	@Test
	void deleteBookingTest_2() {
		int id = 1;
		Optional<Booking> optional = Optional.empty();
		when(repo.findById(id)).thenReturn(optional);
		Executable executable = () -> service.viewBooking(id);
		Assertions.assertThrows(BookingNotFoundException.class, executable);
	}

	/**
	 * Scenario List of all bookings
	 */
	@Test
	void viewAllBookings_Test_1() {
		List<Booking> bookings = mock(List.class);
		when(repo.findAll()).thenReturn(bookings);
		List<Booking> result = repo.findAll();
		Assertions.assertSame(bookings, result);
		verify(repo).findAll();

	}

}
