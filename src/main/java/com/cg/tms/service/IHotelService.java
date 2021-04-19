package com.cg.tms.service;

import com.cg.tms.entities.Hotel;

import java.util.List;

public interface IHotelService {

    Hotel addHotel(Hotel hotel);

    List<Hotel>findAll();

    Hotel findById(int hotelId);
}
