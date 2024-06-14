package com.example.service;

import com.example.model.User;
import com.example.service.Impl.UserServiceImpl;

import java.util.List;

public interface UserServiceI {
    User createUser(User User);   //create
    User UpdateUser(User User, Long userId); //update
    User getSingleUser (Long userId);  // singleData
    List<User> getAllUser();     //alldata
    void DeleteUser(Long userId);  //delete User
}
