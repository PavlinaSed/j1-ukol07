package cz.czechitas.ukol07;

public class Book {
    private String author;
    private String title;
    private int yearOfPublication;


    public Book(String author, String title, int yearOfPublication) {
        this.author = author; //this.author = Objects.requireNonNull(author);
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

}
