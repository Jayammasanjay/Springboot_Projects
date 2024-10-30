package com.example.Ratings.Repository;

import com.example.Ratings.Entity.Rating;
import com.example.Ratings.Entity.RatingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {

    //get rating by UserName
    public List<Rating> findByUserName(String userName);

    //get the rating by hotelName
    public List<Rating> findByHotelName(String name);


    public List<Rating> findByUserId(String userId);


}
