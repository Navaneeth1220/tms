package com.cg.tms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.tms.exceptions.BusNotFoundException;
import com.cg.tms.exceptions.InvalidBusException;
import com.cg.tms.exceptions.InvalidPackageDescriptionException;
import com.cg.tms.exceptions.InvalidPackageIdException;
import com.cg.tms.exceptions.InvalidPackageNameException;
import com.cg.tms.exceptions.InvalidPackageTypeException;
import com.cg.tms.exceptions.InvalidRouteException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	private static final Logger Log = LoggerFactory.getLogger(CentralizedExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PackageNotFoundException.class)
	public String handleStudentNotFound(PackageNotFoundException e) {

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
	@ExceptionHandler(RouteNotFoundException.class)
	public String handleRouteNotFound(RouteNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRouteException.class)
	public String handleInvalidRoute(InvalidRouteException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BusNotFoundException.class)
	public String handleBusNotFound(BusNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidBusException.class)
	public String handleInvalidBus(InvalidBusException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {

		Log.error("parentException caught", e);
		return e.getMessage();
	}

}
