package com.book.json.authentication.Controller;

import com.book.json.authentication.Entities.Books;
import com.book.json.authentication.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookController {

    @Autowired
    //@@autowired helps us the define the objects of the class  without using the traditional methods
    private BookService bookService;

    @GetMapping("/books")
    //ResponseEntity is used to send the message when the list is empty [] instead
    // of showing empty list it sends the output message which is provided
    public ResponseEntity<List<Books>> getBook() {
       /* When I don't define a book service class then I can  use the below format to store the data.
        Books book = new Books();
        book.setId(4011);
        book.setbook("From Scratch");
        return book;*/
        //return "Testing the JSON tokens";
        //  return this.bookService.getAllBooks();
        List<Books> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getOneBook(@PathVariable("id") int id) {
        Books book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }


    // new book handler
    @PostMapping("/books")
    public ResponseEntity<Books> addBookI(@RequestBody Books books) {
        Books books1; //= this.bookService.addBook(books);
        try {
            books1 = this.bookService.addBook(books);
            System.out.println(books1);
            return ResponseEntity.of(Optional.of(books1));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //delete book handler

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try{
            this.bookService.delBook(id);
            return ResponseEntity.ok().build();
            // return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //update the book handler
    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Books books, @PathVariable("id") int id) {
        //this.bookService.addBook(books, id);
        try{
            this.bookService.addBook(books,id);
            // return ResponseEntity.ok().build();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
