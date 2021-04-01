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
	@ExceptionHandler(InvalidCustomerNameException.class)
	public String handleInvalidPackageName(InvalidCustomerNameException e) {

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

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {

		Log.error("parentException caught", e);
		return e.getMessage();
	}

}
