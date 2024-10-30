package com.example.Ratings.Service;

import com.example.Ratings.Entity.Rating;
import com.example.Ratings.Entity.RatingDTO;
import com.example.Ratings.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{


    @Autowired
    private RatingRepository repository;
    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> get() {
        return repository.findAll();
    }

    public List<Rating> getByName(String name) {
        return repository.findByUserName(name);
    }

    public List<Rating> getByHotelName(String name) {
        return repository.findByHotelName(name);
    }

    public List<Rating> getByUserId(String userId){
        return repository.findByUserId(userId);
    }
}
