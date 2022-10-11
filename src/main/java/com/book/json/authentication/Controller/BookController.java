package com.book.json.authentication.Controller;

import com.book.json.authentication.Entities.Books;
import org.springframework.web.bind.annotation.*;

@RestController

public class BookController {

    @GetMapping("/books")

    public Books getBook() {
        Books book = new Books();
        book.setId(4011);
        book.setbook("From Scratch");
        return book;
        //return "Testing the JSON tokens";
    }
}
