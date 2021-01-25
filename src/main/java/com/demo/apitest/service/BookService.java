package com.demo.apitest.service;

import com.demo.apitest.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();
    public String addBook(Book book);
    public Book getBookByIsbn(String isbn);
    public List<Book> getAllBookByAuthor(String author);
    public void removeBook(String isbn);
}
