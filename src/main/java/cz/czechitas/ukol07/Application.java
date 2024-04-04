package cz.czechitas.ukol07;

/**
 * Spouštěcí třída aplikace
 */
public class Application implements Runnable {
    public static void main(String[] args) {
        new Application().run();
    }

    @Override
    public void run() {
        BookService listOfBooks = new BookService();
        System.out.println("The count of all books =" + listOfBooks.getListOfAllBooks().size() + "\n");

        System.out.println("Titles of books written by Karel Čapek:");
        listOfBooks.getBooksFromGivenAuthor("Karel Čapek").forEach(book -> System.out.println(book.getTitle()));

        System.out.println("\nBooks printed in 1845:");
        listOfBooks.getBooksOfGivenYear(1845).forEach(book -> System.out.println(book.getAuthor() + ":" + book.getTitle()));
    }
}
