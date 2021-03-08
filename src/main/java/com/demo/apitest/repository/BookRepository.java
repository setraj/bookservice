package com.demo.apitest.repository;

import com.demo.apitest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book ,String> {
    public Book findBookByIsbn(String isbn);
    public List<Book> findAll();
    public List<Book> findAllByAuthor(String author);
    public void deleteBookByIsbn(String isbn);
}
/*public interface BookRepository extends MongoRepository<Book ,String> {
    public Book findBookByIsbn(String isbn);
    public Book findBookByAuthor(String author);
    public List<Book> findAll();
    public Book findBookByName(String name);
    public List<Book> findAllByAuthor(String author);
    public void deleteBookByIsbn(String isbn);
}*/

/*
    #  Mongo shell commands
    1. show dbs [list dbs]
    2. db [show current db]
    3. use bookstore [use desired db]
    4. db.getCollectionNames() [list collections from current db ]
    5. db.book.find() [list all the data collection]
 */