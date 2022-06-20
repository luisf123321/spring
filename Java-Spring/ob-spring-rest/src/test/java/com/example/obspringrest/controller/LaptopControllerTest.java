package com.example.obspringrest.controller;

import com.example.obspringrest.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

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

        ResponseEntity<String> response = testRestTemplate.getForEntity("/saludo", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("hello world", response.getBody());
    }

    @Test
    void findAll() {

        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Laptop> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void create() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                     
                     "model": "lg-40",
                     "price": 400.5,
                     "mark": "lenovo"
                 }
                                
                """;

        HttpEntity<String> request = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptops", HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();

        assertEquals(1L, result.getId());

    }

    @Test
    void findById() {

        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}