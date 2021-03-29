package com.cg.tms.exceptions;

public class InvalidTravelException extends RuntimeException {

    public InvalidTravelException(){

    }

    public InvalidTravelException(String msg){
        super(msg);
    }

}
