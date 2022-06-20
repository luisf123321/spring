package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(Book.class);

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
        log.warn("create new book");
        return repository.save(book);
    }

    @PutMapping("books")
    public ResponseEntity<Book> update(@RequestBody Book book) {

        if (book.getId() == null) {
            log.warn("try ing to update book no exist");
            return ResponseEntity.badRequest().build();
        }
        if (!repository.existsById(book.getId())) {
            return ResponseEntity.notFound().build();
        }
        Book result = repository.save(book);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/book/{id}")
    @ApiIgnore
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/books")
    @ApiIgnore
    public ResponseEntity<Book> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
