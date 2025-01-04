package com.intelliguru.springdatajpa.controller;

import com.intelliguru.springdatajpa.entity.User;
import com.intelliguru.springdatajpa.service.UserService;
import com.intelliguru.springdatajpa.utils.SecurityContextUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        String userName = SecurityContextUtility.getAuthenticatedUser();
        User existingUser = userService.findByUserName(userName);
        if (existingUser != null) {
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setRoles(user.getRoles());
            userService.createNewUser(existingUser);
            return new ResponseEntity<>("User has been updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Some error occurred while updating the user", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
