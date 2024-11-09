package com.chandu.spring.security.second.repository;

import com.chandu.spring.security.second.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{

}
