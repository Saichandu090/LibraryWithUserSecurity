package com.chandu.spring.security.second.service;

import com.chandu.spring.security.second.dto.UserResponseDTO;
import com.chandu.spring.security.second.model.User;
import com.chandu.spring.security.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public UserResponseDTO addUser(User user)
    {
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setPassword(user.getPassword());
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return userResponseDTO;
    }

}
