package com.example.creditWiseapi.service;

import com.example.creditWiseapi.entity.User;
import com.example.creditWiseapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByName(String name){
        return userRepository.findByName(name).orElseThrow();
    }
}
