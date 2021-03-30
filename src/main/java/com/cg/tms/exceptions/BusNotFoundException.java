package com.cg.tms.exceptions;

public class BusNotFoundException extends RuntimeException {
	public BusNotFoundException(String msg) {
		super(msg);
	}
}
