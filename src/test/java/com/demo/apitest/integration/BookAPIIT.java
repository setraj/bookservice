package com.demo.apitest.integration;

import com.demo.apitest.model.Book;
import com.demo.apitest.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BookAPIIT {

    @Autowired
    BookRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetBookSuccess(){
        repository.save(new Book("1234","book1","auth1",1234));
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("http://localhost:"+ port + "/book/1234", Book.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
