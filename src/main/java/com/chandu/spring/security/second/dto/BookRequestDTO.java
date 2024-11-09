package com.chandu.spring.security.second.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private Integer quantity;

    @Min(value = 100)
    @Max(value = 1000)
    @NotBlank
    private Double price;

    @NotBlank
    private List<String> genre;
}
