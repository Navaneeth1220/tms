package com.cg.tms.service;

import com.cg.tms.entities.Hotel;
import com.cg.tms.exceptions.HotelNotFoundException;
import com.cg.tms.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl  implements IHotelService{
    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
    	
       Hotel saved= hotelRepository.save(hotel);
        return saved;
    }

    @Override
    public List<Hotel> findAll() {
    	
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findByHotelId(int hotelId){
    	
        Optional<Hotel> optional=hotelRepository.findById(hotelId);
        if(!optional.isPresent()){
            throw new HotelNotFoundException("hotel not found for id="+hotelId);
        }
        return optional.get();
    }

}
