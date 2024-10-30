package com.user.service.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private int ratingId;
    private String userId;
    private String userName;
    private int hotelId;
    private String hotelName;
    private double rating;
    private String feedback;
    private  Hotel hotel;
}
