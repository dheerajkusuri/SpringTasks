package com.book.json.authentication.Controller;

import com.book.json.authentication.Entities.Books;
import com.book.json.authentication.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BookController {

    @Autowired
    //@@autowired helps us the define the objects of the class  without using the traditional methods
    private BookService bookService;
    @GetMapping("/books")

    public List<Books> getBook() {
       /* When I don't define a book service class then I can  use the below format to store the data.
        Books book = new Books();
        book.setId(4011);
        book.setbook("From Scratch");
        return book;*/
        //return "Testing the JSON tokens";
            return this.bookService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Books getoneBook(@PathVariable("id") int id){
        return this.bookService.getBookById(id);
    }


    // new book handler
    @PostMapping("/books")
    public Books addBookI(@RequestBody Books books){
        Books books1= this.bookService.addBook(books);
        System.out.println(books1);
        return books1;
    }

    //delete book handler

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
         this.bookService.delBook(id);
    }
}
