package com.chandu.spring.security.second.controller;

import com.chandu.spring.security.second.dto.UserResponseDTO;
import com.chandu.spring.security.second.model.User;
import com.chandu.spring.security.second.service.JWTService;
import com.chandu.spring.security.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService service;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody User user)
    {
        return new ResponseEntity<UserResponseDTO>(service.addUser(user), HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    public String login(@RequestBody User user)
    {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "Login Failed";
    }
}
