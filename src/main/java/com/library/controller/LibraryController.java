package com.library.controller;

import com.library.model.Book;
import com.library.dao.BookDAO;

import java.util.List;

public class LibraryController {

    private final BookDAO bookDAO;

    public LibraryController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(Book book) {
        bookDAO.insert(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Book getBookById(int id) {
        return bookDAO.findById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookDAO.findByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookDAO.findByAuthor(author);
    }

    public List<Book> searchBooksByGenre(String genre) {
        return bookDAO.findByGenre(genre);
    }

    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    public void deleteBook(int id) {
        bookDAO.delete(id);
    }

    private void validateBook(Book book) {
    if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
        throw new IllegalArgumentException("El título no puede estar vacío.");
    }
    if (book.getIsbn() == null || !book.getIsbn().matches("\\d{10,13}")) {
        throw new IllegalArgumentException("ISBN debe tener entre 10 y 13 dígitos.");
    }
}

public void addBook(Book book) {
    validateBook(book);
    bookDAO.insert(book);
}

}