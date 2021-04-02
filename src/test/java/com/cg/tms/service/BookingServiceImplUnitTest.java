package com.cg.tms.service;

import static org.mockito.Mockito.*;

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
	 * Scenario : Successful booking Testcase
	 * input: details of the booking 
	 * expectation: all the values are saved in the database
	 */
	@Test
	void testMakeBooking_1() {
		String ticketId="dads";
		Booking book = mock(Booking.class);
		book.setBookingDate(LocalDate.now());
		doNothing().when(service).validateBooking(book);

		TicketDetails ticket =mock(TicketDetails.class);
		when(book.getTicket()).thenReturn(ticket);
		doReturn(ticketId).when(service).generateId();
		
		when(ticketRepository.save(ticket)).thenReturn(ticket);

		PaymentDetails payment = mock(PaymentDetails.class);
		when(book.getPayment()).thenReturn(payment);
		when(paymentRepository.save(payment)).thenReturn(payment);

		when(repo.save(book)).thenReturn(book);
		Booking result = service.makeBooking(book);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result,book);
		verify(repo).save(book);
		verify(ticketRepository).save(ticket);
		verify(paymentRepository).save(payment);
		
	}

	/**
	 * scenario : id cannot be negative testcase
	 * input : negative id is given
	 * expectation : InvalidBookingException is thrown 
	 */
	@Test
	void testMakeBooking_2() {
		int userId = -1;
		Booking book = mock(Booking.class);
		book.setUserId(userId);
		doThrow(InvalidIdException.class).when(service).validateBooking(book);
		Executable executable = () -> service.makeBooking(book);
		Assertions.assertThrows(InvalidIdException.class, executable);
		verify(repo, never()).save(book);
	}

	/**
	 * scenario : booking type cannot be empty
	 * input : an empty bookingType string is passed
	 * expectation : InvalidBooking exception is thrown
	 */
	@Test
	void testMakeBooking_3() {
		String bookingType = "";
		Booking book = mock(Booking.class);
		book.setBookingType(bookingType);
		doThrow(InvalidBookingException.class).when(service).validateBooking(book);
		Executable executable = () -> service.makeBooking(book);
		Assertions.assertThrows(InvalidBookingException.class, executable);
		verify(repo, never()).save(book);

	}

	/**
	 * scenario : booking title cannot be empty
	 * input : an empty bookingTitle string is passed
	 * expectation : InvalidaBookingException is thrown
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

	/**
	 * scenario : find booking using bookingId
	 * input : bookingId of type integer is passed
	 * expectation : details of the booking for the given id is displayed
	 */
	@Test
	void testFindBooking_1() {
		int id = 1;
		Booking book = mock(Booking.class);
		Optional<Booking> optional = Optional.of(book);
		when(repo.findById(id)).thenReturn(optional);
		Booking result = service.viewBooking(id);
		Assertions.assertEquals(result, book);
		verify(repo).findById(id);
	}

	/**
	 * Scenario : Booking is not found for given id
	 * input : bookingId of type integer is passed
	 * expectation : BookingNotFoundExpectation is thrown 
	 */
	@Test
	void testFindBooking_2() {
		int id = 12;
		Optional<Booking> optional = Optional.empty();
		when(repo.findById(id)).thenReturn(optional);
		Executable executable = () -> service.viewBooking(id);
		Assertions.assertThrows(BookingNotFoundException.class, executable);
	}

	/**
	 * scenario : Deleting a booking using booking id
	 * input : bookingId of type integer is passed
	 * expectation : the booking for given bookingId is deleted
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
	 * Scenario : deleting a booking for given bookingId fails
	 * input : a bookingId that does not exists in datbase
	 * expectation : BookingNotFoundException is thrown
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
	 * Scenario : List of all bookings are displayed
	 * expectation : list of all bookings made are displayed
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
