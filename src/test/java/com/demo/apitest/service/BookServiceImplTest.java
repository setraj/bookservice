package com.demo.apitest.service;

import com.demo.apitest.model.Book;
import com.demo.apitest.repository.BookRepository;
import com.demo.apitest.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testBookSave(){
        Book book = getBook();
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);
        assertThat(bookService.addBook(book)).isEqualTo(book.getIsbn());
    }

    @Test
    void testDeleteBook(){
        Book book = getBook();
        Mockito.when(bookRepository.findBookByIsbn(Mockito.any(String.class))).thenReturn(book);
        bookService.removeBook("isbn123");
        verify(bookRepository, times(1)).deleteBookByIsbn("isbn123");
    }
    private Book getBook(){
        return new Book("isbn123", "qwe", "dsaa", 1234);
    }
}
