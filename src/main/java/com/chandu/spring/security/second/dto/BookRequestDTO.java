package com.chandu.spring.security.second.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO
{
    @NotNull
    private String name;

    @NotNull
    private String author;

    @Min(value = 2)
    private Integer quantity;

    @Min(value = 100)
    @Max(value = 1000)
    private Double price;

    @NotNull
    private List<String> genre;
}
