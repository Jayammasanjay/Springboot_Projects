package com.example.Ratings.Controller;


import com.example.Ratings.Entity.Rating;
import com.example.Ratings.Entity.RatingDTO;
import com.example.Ratings.Service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Ratings")
public class RatingController {

    @Autowired
  private RatingServiceImpl service;



    @PostMapping("/create")
    public Rating create(@RequestBody Rating rating){
        return service.create(rating);
    }


    @GetMapping("/getAllRatings")
    public List<Rating> getAllRatings(){
        return service.get();
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable("userId") String userId){
        List<Rating> ratingList=service.getByUserId(userId);
        List<RatingDTO> ratingDTOS=new ArrayList<>();

        for(Rating rating:ratingList){
            RatingDTO ratingDTO=new RatingDTO(rating.getRating(), rating.getUserName(), rating.getFeedback(), rating.getHotelName());
            ratingDTOS.add(ratingDTO);
        }
        if(!ratingDTOS.isEmpty()){
            return ResponseEntity.ok(ratingDTOS);
        }
        Map<String,String> response=new HashMap<>();
        response.put("message","No rating are given by this Id"+userId);

        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }


    //get all the rating given by user name
    @GetMapping("/getRatingsByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<Rating> ratingsList = service.getByName(name);
        List<RatingDTO> ratingsDtoList = new ArrayList<>();

        for (Rating rating : ratingsList) {
            RatingDTO ratingDto = new RatingDTO(rating.getRating(), rating.getUserName(), rating.getFeedback(),rating.getHotelName());
            ratingsDtoList.add(ratingDto);
        }

        if (!ratingsDtoList.isEmpty()) {
            return ResponseEntity.ok(ratingsDtoList);
        }

        Map<String,String> response=new HashMap<>();
        response.put("message","No rating are given By this name:"+name);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }


    //get all the ratings of hotel by hotelName
    @GetMapping("/getByHotelName/{name}")
    public ResponseEntity<?> hotelName(@PathVariable String name) {
        List<Rating> ratingsList = service.getByHotelName(name);
        List<RatingDTO> ratingsDtoList = new ArrayList<>();

        for (Rating rating : ratingsList) {
            RatingDTO ratingDto = new RatingDTO(rating.getRating(),rating.getUserName(), rating.getFeedback(), rating.getHotelName());
            ratingsDtoList.add(ratingDto);
        }

        if (!ratingsDtoList.isEmpty()) {
            return ResponseEntity.ok(ratingsDtoList);
        }

        // Returning a message with HttpStatus.OK
        Map<String, String> response = new HashMap<>();
        response.put("message", "No content found for the name: " + name);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
