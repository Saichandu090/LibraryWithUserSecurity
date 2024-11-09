package com.chandu.spring.security.second.globalexceptions;

public class BookNotFoundException extends RuntimeException
{
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
