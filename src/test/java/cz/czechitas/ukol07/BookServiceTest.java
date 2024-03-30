package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void getListOfAllBooks() {
        BookService bookService = new BookService(); //tady pozor jestli je new Bookservice() nebo new Bookservis(List) ?
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
        List<Book> result = bookService.getBooksFromGivenAuthor("Karel Čapek");
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