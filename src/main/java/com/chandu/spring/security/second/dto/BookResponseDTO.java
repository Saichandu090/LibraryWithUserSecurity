package com.chandu.spring.security.second.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO
{
    private String name;
    private List<String> genre;
    private Double price;
}
