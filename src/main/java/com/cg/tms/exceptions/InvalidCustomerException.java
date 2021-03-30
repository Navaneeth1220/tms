package com.cg.tms.exceptions;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String msg) {
        super(msg);
    }
}
