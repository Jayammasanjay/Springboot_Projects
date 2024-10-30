package com.user.service.Service;

import com.user.service.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //saving single user
    User save(User user);


    //getting all user
    List<User>getAll();

    //getting single user by Id
    Optional<User> getId(String userID);

    //delete by Id
    Boolean delet(String userId);

    //get the data by name

    List<User> getByName(String name);
}
