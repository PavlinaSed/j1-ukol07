package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void getListOfAllBooks() {
        BookService bookService = new BookService();
        assertEquals(14, bookService.getListOfAllBooks().size());
    }

    @Test
    void getBooksFromGivenAuthor() {
        BookService bookService = new BookService();

        List<String> booksFromKarelCapek = List.of(
                "Válka s Mloky",
                "Bílá nemoc",
                "R. U. R.",
                "Adam stvořitel",
                "Apokryfy"
        );
        Stream<Book> result = bookService.getListOfBooksFromGivenAuthor("Karel Čapek").stream();
        assertIterableEquals(booksFromKarelCapek, result.toList());
        assertThrows(
                NullPointerException.class,book -> book.setAuthor());

    }

    @Test
    void getBooksOfGivenYear() {
    }
}