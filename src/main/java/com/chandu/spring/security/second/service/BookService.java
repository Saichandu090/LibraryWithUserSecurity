package com.chandu.spring.security.second.service;

import com.chandu.spring.security.second.dto.BookRequestDTO;
import com.chandu.spring.security.second.dto.BookResponseDTO;
import com.chandu.spring.security.second.globalexceptions.BookNotFoundException;
import com.chandu.spring.security.second.model.Book;
import com.chandu.spring.security.second.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public BookResponseDTO addBook(BookRequestDTO requestDTO)
    {
        Book book=new Book();
        book.setName(requestDTO.getName());
        book.setAuthor(requestDTO.getAuthor());
        book.setGenre(requestDTO.getGenre());
        book.setPrice(requestDTO.getPrice());
        book.setQuantity(requestDTO.getQuantity());
        return bookResponseToDTO(bookRepository.save(book));
    }

    private BookResponseDTO bookResponseToDTO(Book book)
    {
        BookResponseDTO responseDTO=new BookResponseDTO();
        responseDTO.setName(book.getName());
        responseDTO.setGenre(book.getGenre());
        responseDTO.setPrice(book.getPrice());
        return responseDTO;
    }

    public List<BookResponseDTO> getAllBooks()
    {
        List<Book> bookList=bookRepository.findAll();
        List<BookResponseDTO> responseDTOList=new ArrayList<>();
        for(Book b : bookList)
        {
            responseDTOList.add(bookResponseToDTO(b));
        }
        return responseDTOList;
    }

    public BookResponseDTO findById(int id)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book Not Found!!"));
        return bookResponseToDTO(book);
    }

    public BookResponseDTO updateBook(int id,BookRequestDTO requestDTO)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book Not Found!!"));
        book.setName(requestDTO.getName());
        book.setAuthor(requestDTO.getAuthor());
        book.setGenre(requestDTO.getGenre());
        book.setQuantity(requestDTO.getQuantity());
        book.setPrice(requestDTO.getPrice());
        return bookResponseToDTO(bookRepository.save(book));
    }

    public String deleteBook(int id)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book Not Found!!"));
        bookRepository.delete(book);
        return "Book with Id "+id+" has been deleted from the DataBase Successfully";
    }
}
