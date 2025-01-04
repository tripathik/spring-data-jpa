//package com.intelliguru.springdatajpa.controller;
//
//import com.intelliguru.springdatajpa.entity.User;
//import com.intelliguru.springdatajpa.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public ResponseEntity<?> saveUser(@RequestBody User userData){
//        User user = userService.createNewUser(userData);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//    @GetMapping
//    public ResponseEntity<?> getAllUsers(){
//        List<User> userList = userService.getAllUsers();
//        return new ResponseEntity<>(userList, HttpStatus.OK);
//    }
//}
