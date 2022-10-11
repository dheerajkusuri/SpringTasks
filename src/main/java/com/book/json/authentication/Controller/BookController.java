package com.book.json.authentication.Controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class BookController {

    @GetMapping("/books")

    public String getBook() {
        return "Testing the JSON tokens";
    }
}
