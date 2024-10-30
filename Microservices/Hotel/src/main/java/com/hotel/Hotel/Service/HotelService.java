package com.hotel.Hotel.Service;

import com.hotel.Hotel.Entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    //create
    boolean create(Hotel hotel);

    //GetAll
    List<Hotel> get();

    //Get single hotel by id
    Optional<Hotel> getById(int id);

    //Get single hotel by name;

    Optional<Hotel> getByName(String name);
}
