package com.book.json.authentication.Services;

import com.book.json.authentication.Entities.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static List<Books> list = new ArrayList<>();

    static {
        list.add(new Books(02, "Testing error 02"));
        list.add(new Books(04, "Testing error 04"));
        list.add(new Books(07, "Testing error 07"));
    }

    //GET all the books from list
    public List<Books> getAllBooks() {
        return list;
    }

    //GET single book by id
    public Books getBookById(int id) {
        Books book = null;

        book = list.stream().filter(e ->
                e.getId() == id
        ).findFirst().get();
        return book;
    }

}
