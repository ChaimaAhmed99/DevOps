package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.MyBookRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private MyBookListService myBookService;

    @Autowired
    public BookRepository bookRepository;
    @Autowired
    public MyBookRepository myBookRepository;

    @GetMapping("/")
    public String home(){
        return "home";

    }
    @GetMapping("/admin/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/user/availble_books")
    public ModelAndView getAllBook(){
        List<Book> list=service.getAllBook();
        //ModelAndView m= new ModelAndView();
        // m.setViewName("bookList");
        //m.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/admin/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return"redirect:/user/availble_books";

    }
    @GetMapping("/user/my_Books")
    public String getMyBooks(Model model){
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "MyBooks";
    }
    @RequestMapping("/user/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBook(mb);
        return "redirect:/user/my_Books";
    }
    @RequestMapping("/admin/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";


    }
    @RequestMapping("/admin/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/user/availble_books";
    }

    @GetMapping("/user/addMylist/{id}")
    public String addMyList(@PathVariable("id") int bookId) {
        // Retrieve the Book instance using the bookId
        Book book = bookRepository.getBookById(bookId);
        System.out.println(book.getAuthor());

        // Check if the book is not null before creating MyBookList
        if (book != null) {
            // Create a new instance of MyBookList
            MyBookList myList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
          /* MyBookList myList = MyBookList.builder()
                   .name(book.getName())
                   .price(book.getPrice())
                   .author(book.getAuthor())
                   .id(bookId)
                   .build();
*/
            System.out.println(myList);
            // Save myList using your service class (service.saveMyBook(myList); or similar)
            //myBookService.saveMyBook(myList);
            myBookRepository.save(myList);

            return "redirect:/user/availble_books";
        } else {
            // Handle the case when the book with the given bookId is not found
            return "redirect:/user/availble_books";
        }
    }


}