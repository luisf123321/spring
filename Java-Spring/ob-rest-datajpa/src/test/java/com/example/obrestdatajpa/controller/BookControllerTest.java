package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;


    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {

        ResponseEntity<String> response = testRestTemplate.getForEntity("/hello", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("hello world, usco", response.getBody());
    }

    @Test
    void findAll() {

        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());

    }

    @Test
    void findById() {
        ResponseEntity<Book> response = testRestTemplate.getForEntity("/books/1", Book.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    void createBook() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                { 
                    "title": "java",
                    "author": "luis",
                    "pages": 200,
                    "price": 4.21,
                    "releaseDate": "2014-07-01",
                    "online": true
                }
                                
                """;

        HttpEntity<String> request = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<Book> response = testRestTemplate.exchange("/books", HttpMethod.POST, request, Book.class);
        Book result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("java",result.getTitle());

    }
}