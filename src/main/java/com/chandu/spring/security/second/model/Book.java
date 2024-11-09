package com.chandu.spring.security.second.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "library")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer quantity;
    private Double price;
    @ElementCollection
    @CollectionTable(name = "genre_table",joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<String> genre;
}
