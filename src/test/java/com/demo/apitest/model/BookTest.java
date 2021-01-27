package com.demo.apitest.model;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    @Test
    public void testBookObjectCreationWithConstructor(){
        Book book = new Book("123s", "book1", "david", 1234);
        assertThat(book).isNotNull();
    }
}
