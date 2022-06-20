package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void caltulator() {

        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();
        Book book = new Book(null, "cien años de soledad", "gabriel", 300, 49.21,
                LocalDate.of(2018, 04, 01), true);
        double price = bookPriceCalculator.caltulator(book);

        assertTrue(price > 0);
    }
}