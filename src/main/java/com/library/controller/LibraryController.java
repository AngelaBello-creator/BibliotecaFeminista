package main.java.com.library.controller;

import main.java.com.library.model.Book;
import main.java.com.library.dao.BookDao;

import java.util.List;

public class LibraryController {

    private final BookDao BookDao;

    public LibraryController(BookDao BookDao) {
        this.BookDao = BookDao;
    }

    public void addBook(Book book) {
        BookDao.insert(book);
    }

    public List<Book> getAllBooks() {
        return BookDao.findAll();
    }

    public Book getBookById(int id) {
        return BookDao.findById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return BookDao.findByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return BookDao.findByAuthor(author);
    }

    public List<Book> searchBooksByGenre(String genre) {
        return BookDao.findByGenre(genre);
    }

    public void updateBook(Book book) {
        BookDao.update(book);
    }

    public void deleteBook(int id) {
        BookDao.delete(id);
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
    BookDao.insert(book);
}

}