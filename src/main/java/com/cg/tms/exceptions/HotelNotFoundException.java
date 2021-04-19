package com.cg.tms.exceptions;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(){

    }

    public HotelNotFoundException(String msg){
        super(msg);
    }

}
