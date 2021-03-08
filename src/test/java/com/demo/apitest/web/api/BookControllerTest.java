package com.demo.apitest.web.api;

import com.demo.apitest.model.Book;
import com.demo.apitest.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {

    private static final String URL = "/book";

    @MockBean
    BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
    }

    @Test
    public void SuccessCase() throws Exception {
        Book book = new Book("1234","book1","auth1",123 );
        Mockito.when(bookService.getBookByIsbn(Mockito.anyString())).thenReturn(getBook());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL+"/1234")
                                                        .accept(MediaType.APPLICATION_JSON)
                                                        .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(result.getResponse().getContentAsString(),mapper.writeValueAsString(getBook()),false);

    }

    private Book getBook(){
        return new Book("1234","book1","auth1",123 );
    }
}
