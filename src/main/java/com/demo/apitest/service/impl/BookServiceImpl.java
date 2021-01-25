package com.demo.apitest.service.impl;

import com.demo.apitest.exception.ResourceNotFoundException;
import com.demo.apitest.model.Book;
import com.demo.apitest.repository.BookRepository;
import com.demo.apitest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

     @Autowired
     BookRepository bookRepository;

     @Override
     public List<Book> getAllBook(){
      return bookRepository.findAll();
    }

    @Override
    public String addBook(Book book) {
        Book resp = bookRepository.save(book);
        return resp.getIsbn();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);
        if(book == null){
            throw new ResourceNotFoundException("Book with isbn " + isbn + " not found");
        }
        return book;
    }

    @Override
    public List<Book> getAllBookByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public void removeBook(String isbn) {
        Book book = getBookByIsbn(isbn);
        if(book != null){
        bookRepository.deleteBookByIsbn(isbn);
        }
    }

}
