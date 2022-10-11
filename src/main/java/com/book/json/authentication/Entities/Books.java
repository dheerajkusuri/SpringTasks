package com.book.json.authentication.Entities;

public class Books {
    private int id;
    private String book;

    public Books(int id, String book) {
        this.id = id;
        this.book = book;
    }

    public Books() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getbook() {
        return book;
    }

    public void setbook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + id +
                ", book='" + book + '\'' +
                '}';
    }
}
