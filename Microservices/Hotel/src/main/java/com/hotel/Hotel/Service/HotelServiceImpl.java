package com.hotel.Hotel.Service;

import com.hotel.Hotel.Entity.Hotel;
import com.hotel.Hotel.Exception.IdNotFoundException;
import com.hotel.Hotel.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository repository;


    @Override
    public boolean create(Hotel hotel) {
        Hotel hotel1= repository.save(hotel);
        return hotel1!=null;
    }

    @Override
    public List<Hotel> get() {
        return repository.findAll();
    }

    @Override
    public Optional<Hotel> getById(int id) {
        Optional<Hotel> hotel= repository.findById(id);
        if(hotel.isPresent()){
            return hotel;
        }
        throw new IdNotFoundException("ID Not Found:"+id);
    }

    @Override
    public Optional<Hotel> getByName(String name) {
        Optional<Hotel> hotel= Optional.ofNullable(repository.findByName(name));
        if (hotel.isPresent()){
            return hotel;
        }
        return Optional.empty();
    }
}
