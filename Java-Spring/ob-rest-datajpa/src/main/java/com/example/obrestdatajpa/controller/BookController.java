package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("books")
    public List<Book> findAll() {
        return repository.findAll();
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {

        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("books")
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }


}
