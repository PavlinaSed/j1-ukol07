package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookService {
    private List<Book> listOfBooks;

    public BookService(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public BookService() {
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = BookService.class.getResourceAsStream("knihy.json")) {
            listOfBooks = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            System.out.println("ERR: The file has not been found.");
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("ERR:List of books is null value.");
            throw new RuntimeException(e);
        }
        this.listOfBooks = listOfBooks;
    }


    public List<Book> getListOfAllBooks() {
        return listOfBooks;
    }

    public List<Book> getBooksFromGivenAuthor(String author) {
        return listOfBooks.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }


    public List<Book> getBooksOfGivenYear(int yearOfPublication) {
        return listOfBooks.stream()
                .filter(book -> book.getYearOfPublication() == yearOfPublication)
                .toList();
    }

    @Override
    public String toString() {
        return "BookService{" +
                "list of all books=" + listOfBooks +
                '}';
    }
}
