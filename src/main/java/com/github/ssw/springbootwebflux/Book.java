package com.github.ssw.springbootwebflux;

public class Book {

    private String title;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(){

    }


    public Book(String title, String isbn){
        this.title = title;
        this.isbn = isbn;
    }
}
