package com.example.librarymanagement.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Book {

    private Long id;

    private String name;

    private String author;

    private Double price;

    private Integer count;
}
