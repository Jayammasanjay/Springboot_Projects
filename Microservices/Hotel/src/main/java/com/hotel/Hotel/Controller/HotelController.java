package com.hotel.Hotel.Controller;


import com.hotel.Hotel.Entity.Hotel;
import com.hotel.Hotel.Exception.IdNotFoundException;
import com.hotel.Hotel.Service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createHotel(@RequestBody Hotel hotel){
        Boolean hotel1= service.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotel=service.get();
        return  ResponseEntity.ok(hotel);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Hotel>> getById(@PathVariable("id") int id){
        Optional<Hotel> hotel=service.getById(id);
        if (hotel.isPresent()){
            return ResponseEntity.ok(hotel);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getByName/{name}")
        public ResponseEntity<Optional<?>> getByName(@PathVariable("name") String name){
        Optional<Hotel> hotel=service.getByName(name);
        if (hotel.isPresent()){
            return ResponseEntity.ok(hotel);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
