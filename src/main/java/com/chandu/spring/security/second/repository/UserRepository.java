package com.chandu.spring.security.second.repository;

import com.chandu.spring.security.second.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByUsername(String username);
}
