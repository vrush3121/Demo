package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceI;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    //http
    //status code

    //pathvariable  single path
    //Requestparam  multiple path
    //RequestBody
    //
    @Autowired
    private UserServiceI userServiceI;
    @PostMapping("/users")
    public ResponseEntity<User>createUser(@RequestBody User user){
        User saveduser = userServiceI.createUser(user);
            return new ResponseEntity<>(saveduser, HttpStatus.OK);
        }


    @GetMapping("/users")
    public ResponseEntity<List<User>>getAllUsers(){
        List<User>allUsers=userServiceI.getAllUser();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User>getSingUsers(@PathVariable Long userId){
        User user = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User>UpdateUsers(@RequestBody User user,@PathVariable Long userId) {
        User updatedUser = userServiceI.UpdateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User>deleteUsers(@PathVariable Long userId){
        userServiceI.DeleteUser(userId);
        User body = null;
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
