package com.user.service.Respository;

import com.user.service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositroy extends JpaRepository<User,String> {


    public List<User> findByUserName(String userName);

    List<User> findByUserNameContainingIgnoreCase(String name);
}
