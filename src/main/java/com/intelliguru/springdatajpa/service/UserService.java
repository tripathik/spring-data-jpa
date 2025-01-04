package com.intelliguru.springdatajpa.service;

import com.intelliguru.springdatajpa.entity.User;
import com.intelliguru.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //@Autowired
    //private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;

    public User createNewUser(User userData) {
        User user = new User();
        user.setUserName(userData.getUserName());
        user.setEmail(userData.getEmail());
        //user.setPassword(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
