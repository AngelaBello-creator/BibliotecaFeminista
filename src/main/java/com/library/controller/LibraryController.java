package com.library.controller;

import com.library.dao.BookDao;
import com.library.model.entities.Book;

import java.util.List;

public class LibraryController {

    private final BookDao BookDAO;

    public LibraryController(BookDao bookDAO) {
        this.BookDAO = bookDAO;
    }

    public void addBook(Book book) {
        validateBook(book);
        BookDAO.insert(book);
    }

    public List<Book> getAllBooks() {
        return BookDAO.findAll();
    }

    public Book getBookById(int id) {
        return BookDAO.findById(id);
    }

    public Book findByTitle(String title) {
        List<Book> books = BookDAO.findByTitle(title);
        return books.isEmpty() ? null : books.get(0);
    }

    public List<Book> findByAuthor(String author) {
        return BookDAO.findByAuthor(author);
    }

    public List<Book> findByGenre(String genre) {
        return BookDAO.findByGenre(genre);
    }

    public void updateBook(int id, String newTitle) {
        Book book = BookDAO.findById(id);
        if (book != null) {
            book.setTitle(newTitle);
            BookDAO.update(book);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public void deleteBook(int id) {
        BookDAO.delete(id);
    }

    private void validateBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (book.getIsbn() != null && !book.getIsbn().isEmpty() && 
            !book.getIsbn().matches("\\d{10,13}")) {
            throw new IllegalArgumentException("ISBN debe tener entre 10 y 13 dígitos.");
        }
    }
}