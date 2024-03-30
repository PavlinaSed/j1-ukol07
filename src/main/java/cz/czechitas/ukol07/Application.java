package cz.czechitas.ukol07;

import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Application implements Runnable {
    public static void main(String[] args) {
        new Application().run();
    }

    @Override
    public void run() {
        BookService bookService = new BookService();
        BookService listOfBooks = new BookService();
        System.out.println("The count of all books =" + listOfBooks.getListOfAllBooks().size());

        List<Book> booksFromKarelCapek = listOfBooks.getBooksFromGivenAuthor("Karel Čapek");
        System.out.println(booksFromKarelCapek);

        listOfBooks.getBooksOfGivenYear(1845).forEach(book -> System.out.println(book.getAuthor() + ":" + book.getTitle()));
    }
}
