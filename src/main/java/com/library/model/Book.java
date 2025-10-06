package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String isbn;
    private String description;
    private List<Author> authors;
    private List<Genre> genres;

    public Book() {
        this.authors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    // Constructor sin ID (para insertar)
    public Book(String title, String authorName, String description, String isbn, String genreName) {
        this();
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.addAuthor(new Author(authorName));
        this.addGenre(new Genre(genreName));
    }

    // Constructor con ID (para leer desde BD)
    public Book(int id, String title, String isbn, String description) {
        this();
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
    }

    // Métodos para manejar listas
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public String getAuthorsAsString() {
        if (authors.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Author a : authors) {
            sb.append(a.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public String getGenresAsString() {
        if (genres.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Genre g : genres) {
            sb.append(g.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "📖 ID: " + id +
                "\nTítulo: " + title +
                "\nAutores: " + getAuthorsAsString() +
                "\nGéneros: " + getGenresAsString() +
                "\nISBN: " + isbn +
                "\nDescripción: " + description +
                "\n----------------------------";
    }
}
