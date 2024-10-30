package com.user.service.Service;

import com.example.Ratings.Entity.RatingDTO;
import com.user.service.Entity.Rating;
import com.user.service.Entity.User;
import com.user.service.Exceptions.ResourceNotFoundException;
import com.user.service.Respository.UserRepositroy;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepositroy repository;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public User save(User user) {
        // Generate unique User ID as a string
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return repository.save(user);
    }

    // Retrieve list of all users
    @Override
    public List<User> getAll() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users are found");
        }
        return users;
    }

    // Retrieve a specific user by ID
    @Override
    public Optional<User> getId(String userID) {
        Optional<User> userId = repository.findById(userID);

        if (userId.isPresent()) {
            User user = userId.get();
            ArrayList<RatingDTO> ratings = restTemplate.getForObject("http://RATINGS/Ratings/getByUserId/" + userID, ArrayList.class);
           // logger.info("{}", ratings);
            user.setRatings(ratings);
            return Optional.of(user);
        } else {
            throw new ResourceNotFoundException("User with ID '" + userID + "' not found.");
        }

    }

    // Delete user by ID
    @Override
    public Boolean delet(String userId) {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            repository.deleteById(userId);
            return true;
        } else {
            throw new ResourceNotFoundException("User with ID '" + userId + "' not found.");
        }
    }



    // Retrieve users by name
    @Override
    public List<User> getByName(String name) {
        List<User> users = repository.findByUserName(name);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("User with the name '" + name + "' not found.");
        }

        // Fetch ratings for each user
        for (User user : users) {
            ArrayList<RatingDTO> getRatingsByUserName = restTemplate.getForObject("http://RATINGS/Ratings/getRatingsByName/" + user.getUserName(), ArrayList.class);
            user.setRatings(getRatingsByUserName);
        }

        return users;
    }

    // Search users by name containing the specified substring (case-insensitive)
    public List<User> searchUsersByName(String name) {
        List<User> users = repository.findByUserNameContainingIgnoreCase(name);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No Name Found!!");
        }
        return users;
    }
}
