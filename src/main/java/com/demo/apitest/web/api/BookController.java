package com.demo.apitest.web.api;

import com.demo.apitest.model.Book;
import com.demo.apitest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    public BookController(@Autowired BookService bookService){
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(value = "author", required = false)String author) {
        if(author == null){
            return bookService.getAllBook();
        }
        else{
            return bookService.getAllBookByAuthor(author);
        }

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{isbn}")
    public void removeBook(@PathVariable String isbn){
        bookService.removeBook(isbn);
    }
}
