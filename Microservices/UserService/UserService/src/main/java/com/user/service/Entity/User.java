package com.user.service.Entity;


import com.example.Ratings.Entity.RatingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Users")
public class User {

    @Id
    @Column(name = "userId")
    private String userId;


    @Column(name="userName")
    private String userName;


    @Column(name = "userEmail")
    private String email;

    @Transient//Not to store in dataBase
    private List<RatingDTO> ratings;

}
