package com.chandu.spring.security.second.controller;

import com.chandu.spring.security.second.dto.BookRequestDTO;
import com.chandu.spring.security.second.dto.BookResponseDTO;
import com.chandu.spring.security.second.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookController
{
    @Autowired
    private BookService bookService;

    @GetMapping
    public String greet()
    {
        return "Welcome to Book Store";
    }

    @PostMapping("/addBook")
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO requestDTO)
    {
        return new ResponseEntity<BookResponseDTO>(bookService.addBook(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/allBooks")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks()
    {
        return new ResponseEntity<List<BookResponseDTO>>(bookService.getAllBooks(),HttpStatus.FOUND);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<BookResponseDTO> findById(@PathVariable int id)
    {
        return new ResponseEntity<BookResponseDTO>( bookService.findById(id),HttpStatus.FOUND);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable int id,@RequestBody BookRequestDTO requestDTO)
    {
        return new ResponseEntity<BookResponseDTO>(bookService.updateBook(id,requestDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id)
    {
        return new ResponseEntity<String>(bookService.deleteBook(id),HttpStatus.ACCEPTED);
    }
}
