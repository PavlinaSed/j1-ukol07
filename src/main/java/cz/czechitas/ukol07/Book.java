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

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        //bonus
        if (author == null) {
            throw new IllegalArgumentException("author value is null value");
        } else if (author.isEmpty()) {
            throw new IllegalArgumentException(("author value is empty"));
        } else
            this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title value is null value");
        } else if (title.isEmpty()) {
            throw new IllegalArgumentException(("title value is empty"));
        } else
            this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        if (yearOfPublication > 1440) {
            throw new IllegalArgumentException("the year of publication is not valid");
        }
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year of publication=" + yearOfPublication +
                '}';
    }

}
