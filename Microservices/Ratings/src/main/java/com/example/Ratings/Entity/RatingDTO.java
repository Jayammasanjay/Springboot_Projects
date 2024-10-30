package com.example.Ratings.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RatingDTO {


    private double rating;
    private String userName;
    private String feedback;
    private String hotelName;

}
