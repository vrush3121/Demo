package com.example.service.Impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserServiceI {
@Autowired

// IOC -Spring life cycle
    private UserRepository userRepository;


    @Override
    public User createUser(User User) {
        return null;
    }

    @Override
    public User UpdateUser(User User, Long userId) {
        return null;
    }

    @Override
    public User getSingleUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void DeleteUser(Long userId) {

    }
}
