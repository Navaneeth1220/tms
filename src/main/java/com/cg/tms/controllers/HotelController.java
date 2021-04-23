package com.cg.tms.controllers;

import com.cg.tms.dto.CreateHotelRequest;
import com.cg.tms.dto.HotelDetails;
import com.cg.tms.entities.Hotel;
import com.cg.tms.service.IHotelService;
import com.cg.tms.util.HotelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotels")
@RestController
public class HotelController {

    @Autowired
    private HotelUtil hotelUtil;

    @Autowired
    private IHotelService hotelService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public HotelDetails addHotel(@RequestBody CreateHotelRequest request){
     	/*
		 * Hotel hotel=hotelUtil.toHotel(requestData); HotelDetails
		 * hotelDetails=hotelUtil.toHotelDetails(hotel); return hotelDetails;
		 */
		Hotel hotel = new Hotel();
		hotel.setHotelName(requestData.getHotelName());
		hotel.setHotelDescription(requestData.getHotelDescription());
		hotel.setHotelType(requestData.getHotelType());
		hotel.setAddress(requestData.getAddress());
		hotel.setRent(requestData.getRent());
		Hotel added = hotelService.addHotel(hotel);
		HotelDetails response = hotelUtil.toHotelDetails(added);
		return response;
		
    }

    @GetMapping("/byid/{hotelId}")
    public HotelDetails getHotelById(@PathVariable("hotelId") int hotelId){
        Hotel hotel=hotelService.findByHotelId(hotelId);
        HotelDetails hotelDetails=hotelUtil.toHotelDetails(hotel);
        return hotelDetails;
    }

    @GetMapping
    public List<HotelDetails>getAllHotels(){
        List<Hotel>hotels=hotelService.findAll();
        List<HotelDetails>desired=hotelUtil.toList(hotels);
        return desired;
    }


}
