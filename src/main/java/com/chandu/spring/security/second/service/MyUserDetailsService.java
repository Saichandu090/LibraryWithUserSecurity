package com.chandu.spring.security.second.service;

import com.chandu.spring.security.second.model.User;
import com.chandu.spring.security.second.model.UserPrinciple;
import com.chandu.spring.security.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user=repository.findByUsername(username);
        if(user==null)
        {
            System.out.println("Not Found 404");
            throw new UsernameNotFoundException("User Not Found 404");
        }

        return new UserPrinciple(user);
    }
}
