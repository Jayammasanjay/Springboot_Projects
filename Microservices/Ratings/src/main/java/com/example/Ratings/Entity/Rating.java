package com.example.Ratings.Entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "Ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingId")
    private int ratingId;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "UserName")
    private String userName;

    private int hotelId;
    private String hotelName;
    private double rating;
    private String feedback;
}
