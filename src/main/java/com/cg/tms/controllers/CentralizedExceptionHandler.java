package com.cg.tms.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import com.cg.tms.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	private static final Logger Log = LoggerFactory.getLogger(CentralizedExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PackageNotFoundException.class)
	public String handlePackageNotFound(PackageNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageIdException.class)
	public String handleInvalidPackageId(InvalidPackageIdException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageNameException.class)
	public String handleInvalidPackageName(InvalidPackageNameException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageDescriptionException.class)
	public String handleInvalidPackageDescription(InvalidPackageDescriptionException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageTypeException.class)
	public String handleInvalidPackageType(InvalidPackageTypeException e) {

		return e.getMessage();
	}


	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFound(CustomerNotFoundException e) {

		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerNameException.class)
	public String handleInvalidCustomerName(InvalidCustomerNameException e) {

		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerAddressException.class)
	public String handleInvalidCustomerAddress(InvalidCustomerAddressException e) {

		return e.getMessage();
	}

 	@ExceptionHandler(BookingNotFoundException.class)
	public String handleBookingNotFound(BookingNotFoundException e) {

		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidBookingException.class)
	public String handleInvalidBooking(InvalidBookingException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ReportNotFoundException.class)
	public String handleReportNotFound(ReportNotFoundException e) {

		return e.getMessage();
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidReportException.class)
	public String handleInvalidReport(InvalidReportException e) {

		return e.getMessage();
	}

                 @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RouteNotFoundException.class)
	public String handleRouteNotFound(RouteNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRouteException.class)
	public String handleInvalidRoute(InvalidRouteException e) {

		return e.getMessage();
	}

                 @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidFeedbackException.class)
	public String handleInvalidFeedback(InvalidFeedbackException e) {

		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeedbackNotFoundException.class)
	public String handleFeedbackNotFound(FeedbackNotFoundException e) {

		return e.getMessage();
	}

                 @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TravelsNotFoundException.class)
	public String handleTravelsNotFound(TravelsNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidTravelException.class)
	public String handleInvalidTravels(InvalidTravelException e) {

		return e.getMessage();
	}
	
               


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {

		Log.error("parentException caught", e);
		return e.getMessage();
	}

}
