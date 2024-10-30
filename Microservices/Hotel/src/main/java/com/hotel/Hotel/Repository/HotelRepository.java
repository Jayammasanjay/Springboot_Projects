package com.hotel.Hotel.Repository;

import com.hotel.Hotel.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    public Hotel findByName(String name);
}
