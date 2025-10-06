package com.library.model;


import java.util.ArrayList;
import java.util.List;


public class Book {
    private Integer id;
    private String title;
    private String isbn;
    private String description;
    private List<Author> authors;
    private List<Genre> genres;

    public Book() {
        this.authors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public Book(Integer id, String title, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public Book(String title, String isbn, String description) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > 200) {
            this.description = description.substring(0, 200);
        } else {
            this.description = description;
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        if (author != null && !this.authors.contains(author)) {
            this.authors.add(author);
        }
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        if (genre != null && !this.genres.contains(genre)) {
            this.genres.add(genre);
        }
    }

    public String getAuthorsAsString() {
        if (authors.isEmpty()) {
            return "Sin autor";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            sb.append(authors.get(i).getName());
            if (i < authors.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String getGenresAsString() {
        if (genres.isEmpty()) {
            return "Sin género";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            sb.append(genres.get(i).getName());
            if (i < genres.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + getAuthorsAsString() +
                ", genres=" + getGenresAsString() +
                '}';
    }

    public String toStringWithDescription() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", authors=" + getAuthorsAsString() +
                ", genres=" + getGenresAsString() +
                '}';
    }
}