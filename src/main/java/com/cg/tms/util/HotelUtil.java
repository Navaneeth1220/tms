package com.cg.tms.util;

import com.cg.tms.dto.CreateHotelRequest;
import com.cg.tms.dto.HotelDetails;
import com.cg.tms.entities.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelUtil {


    public Hotel toHotel(CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(request.getHotelName());
        hotel.setAddress(request.getAddress());
        hotel.setHotelDescription(request.getHotelDescription());
        hotel.setHotelType(request.getHotelType());
        hotel.setRent(request.getRent());
        return hotel;
    }

    public HotelDetails toHotelDetails(Hotel hotel) {
        HotelDetails details = new HotelDetails();
        details.setHotelId(hotel.getHotelId());
        details.setAddress(hotel.getAddress());
        details.setHotelName(hotel.getHotelName());
        details.setRent(hotel.getRent());
        details.setHotelDescription(hotel.getHotelDescription());
        details.setHotelType(hotel.getHotelType());
        return details;
    }

    public List<HotelDetails> toList(Collection<Hotel> hotels) {
        if (hotels == null) {
            return new ArrayList<>();
        }
        List<HotelDetails>desired=new ArrayList<>();
        for (Hotel hotel:hotels){
            HotelDetails details=toHotelDetails(hotel);
            desired.add(details);
        }
        return desired;

    }

}
