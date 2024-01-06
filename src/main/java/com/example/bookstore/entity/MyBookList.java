package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

@NoArgsConstructor

@Table(name = "MyBooks")
public class MyBookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String author;
    private String price;

   /* @ElementCollection
    @CollectionTable(name = "book_list", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "element")
    private List<String> elements;
*/
    /*
   public MyBookList(int id, String name, String author, String price) {
    super();
    }*/

    public MyBookList(int id, String name, String author, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }



    // Getters and setters for existing fields...
/*
    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }
*/
}