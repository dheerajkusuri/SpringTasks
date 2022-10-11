package com.book.json.authentication.Services;

import com.book.json.authentication.Entities.Books;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component //@Service can also be be used as we are using the @Autowired in the Book Controller
// class instead of creating the object for the class
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
        try {
            book = list.stream().filter(e ->
                    e.getId() == id
            ).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public Books addBook(Books books) {
        list.add(books);
        return books;
    }

    public void delBook(int id) {

        list = list.stream().filter(book -> book.getId() != id
       /* {
            if (book.getId() != id) {
                return true;
            } else {
                return false;
            }
        }*/).collect(Collectors.toList());
    }

    //Update the books
    public void addBook(Books books, int id) {
        list = list.stream().map(b -> {
            if (b.getId() == id) {
                b.setbook(books.getbook());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
