package com.chandu.spring.security.second.controller;

import com.chandu.spring.security.second.dto.UserResponseDTO;
import com.chandu.spring.security.second.model.User;
import com.chandu.spring.security.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController
{
    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody User user)
    {
        return new ResponseEntity<UserResponseDTO>(service.addUser(user), HttpStatus.ACCEPTED);
    }
}
