package com.chandu.spring.security.second.globalexceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BookNotFoundException.class)
    public String bookNotFoundException(BookNotFoundException e)
    {
        return e.getMessage();
    }
}
