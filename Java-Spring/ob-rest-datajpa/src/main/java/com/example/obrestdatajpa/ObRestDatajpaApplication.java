package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
        BookRepository repository = (BookRepository) context.getBean(BookRepository.class);

        // crear libro
        Book book = new Book(null, "cien años de soledad", "gabriel", 300, 49.21,
                LocalDate.of(2018, 04, 01), true);

        Book book2 = new Book(null, "cien años de soledad", "gabriel", 300, 49.21,
                LocalDate.of(2013, 04, 01), true);
        // almacenar libro
        repository.save(book);
        repository.save(book2);


        // recuperar libro
        System.out.println(repository.findAll().size());
        repository.findAll();

        //eliminar libro

        repository.deleteById(1L);

        // recuperar libro
        System.out.println(repository.findAll().size());
        repository.findAll();


    }

}
