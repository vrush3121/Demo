package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceI{
    private UserRepository userRepository;


    //IOC- spring life cycle,DI
    //dependencyu injection-setter,constructor,field DI


 public User createUser(User user){
     User savedUser  = userRepository.save(user);
     return savedUser;
 }
    @Override
    public User UpdateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setUserAbout(user.getUserAbout());
      User updatedUser= userRepository.save(user1);
        return updatedUser;
    }

    @Override
    public User getSingleUser(Long userId) {
         User user = userRepository.findById(userId)
                 .orElseThrow(()  ->new RuntimeException("resourse not found on server !"+userId));
         return user;
    }
   /* public User getSingleUser(Long userId) {
        Optional<User> user = userRepository.findById();
        if(user.isPresent()) {
            return user.get();
        }else {
            throw new NullPointerException(" Resourse not found on server ! "+userId);

        }
      */

    @Override
    public List<User> getAllUser() {
      List<User>allusers = userRepository.findAll();
        return allusers;
    }

    @Override
    public void DeleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()  ->new RuntimeException("resourse not found on server !"+userId));
             userRepository.delete(user);
}
}