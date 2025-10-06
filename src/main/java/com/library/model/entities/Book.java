package com.library.model.entities;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private String genre;

    public Book(int id, String title, String author, String description, String isbn, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Book(String title, String author, String description, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.genre = genre;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Título: " + title +
               ", Autor: " + author +
               ", ISBN: " + (isbn != null ? isbn : "N/A") +
               ", Género: " + genre +
               ", Descripción: " + description;
    }
}