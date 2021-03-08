package com.demo.apitest.service;

import com.demo.apitest.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> getAllBook();
    public String addBook(Book book);
    public Book getBookByIsbn(String isbn);
    public List<Book> getAllBookByAuthor(String author);
    public void removeBook(String isbn);
}
