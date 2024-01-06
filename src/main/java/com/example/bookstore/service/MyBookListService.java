package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository mybook;

    @Autowired
    private BookService bookService;  // Add this line

    public void saveMyBook(MyBookList book) {
        mybook.save(book);
    }

    public List<MyBookList> getAllMyBooks() {
        return mybook.findAll();
    }

    public void deleteById(int id) {
        mybook.deleteById(id);
    }

    public void addMyList(MyBookList book) {
        mybook.save(book);
    }

    public Book getBookById(int bookId) {
        return bookService.getBookById(bookId);
    }
}