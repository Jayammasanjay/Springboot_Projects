package com.user.service.Controller;

import com.user.service.Entity.User;
import com.user.service.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp service;


    @PostMapping("/adduser")
    public ResponseEntity<Boolean> createUser(@RequestBody User user){
        User user1= service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping("/getBYId/{userId}")
    public ResponseEntity<Optional<?>> getUserById(@PathVariable("userId") String userId){
        Optional<?> user=service.getId(userId);
        if (user.isPresent()){
            return ResponseEntity.ok(user);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user=service.getAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<User>> getByName(@PathVariable("name") String name){
        List<User> users=service.getByName(name);
        if(name.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/users/search/name/{name}")
    public ResponseEntity<List<User>> searchUsersByName(@PathVariable String name) {
        List<User> users = service.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }
}
