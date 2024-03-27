package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BookService {

    private List<Book> listOfBooks;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public BookService(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    //
    //
    public void loadBooksFromFile() {
        try {
            InputStream inputStream = BookService.class.getResourceAsStream("knihy.json");
            listOfBooks = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            System.out.println("ERR: The file has not been found.");
            throw new RuntimeException(e);
        }
    }


}
