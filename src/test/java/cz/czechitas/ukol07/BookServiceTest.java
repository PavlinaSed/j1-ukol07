package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        List<String> result = bookService.getBooksFromGivenAuthor("Karel Čapek").stream().map(Book::getTitle).toList();
        assertIterableEquals(booksFromKarelCapek, result);

        int resultOfBozenaBooks = bookService.getBooksFromGivenAuthor("Božena Němcová").size();
        assertEquals(4, resultOfBozenaBooks);
        assertNotEquals(5, resultOfBozenaBooks);
        assertEquals(0, bookService.getBooksFromGivenAuthor("Peter Hoeg").size());
    }

    @Test
    void getBooksOfGivenYear() {
        BookService bookService = new BookService();
        int resultNumberOfBooks1845 = bookService.getBooksOfGivenYear(1845).size();
        assertEquals(2, resultNumberOfBooks1845);
        assertEquals(0,bookService.getBooksOfGivenYear(1439).size());
    }
}