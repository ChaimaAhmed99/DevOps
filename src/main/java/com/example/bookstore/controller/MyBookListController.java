package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyBookListController {
    @Autowired
    private MyBookListService service;
    @RequestMapping("/user/deleteMyList/{id}")

    public String deleteMyList(@PathVariable("id") int id){
        service.deleteById(id);
        return "MyBooks";
    }



}