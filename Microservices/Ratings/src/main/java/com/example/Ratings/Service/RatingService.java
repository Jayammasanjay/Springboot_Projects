package com.example.Ratings.Service;

import com.example.Ratings.Entity.Rating;

import java.util.List;

public interface RatingService {

    //create rating

    public Rating create(Rating rating);

    //getAll
    public List<Rating> get();
}
