package com.library.controller;

import com.library.model.Book;
import com.library.dao.BookDao;
import static com.library.util.ConsoleColor.*;

import java.util.List;

public class LibraryController {

    private final BookDao bookDao;

    public LibraryController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        validateBook(book);
        bookDao.insert(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(int id) {
        return bookDao.findById(id);
    }

    public Book findByTitle(String title) {
        List<Book> books = bookDao.findByTitle(title);
        return books.isEmpty() ? null : books.get(0);
    }

    public List<Book> findByAuthor(String author) {
        return bookDao.findByAuthor(author);
    }

    public List<Book> findByGenre(String genre) {
        return bookDao.findByGenre(genre);
    }

    public void updateBook(Book book) {
        validateBook(book);
        bookDao.update(book);
    }

    public void deleteBook(int id) {
        bookDao.delete(id);
    }

    private void validateBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException(red("El título no puede estar vacío."));
        }
        if (book.getIsbn() != null && !book.getIsbn().isEmpty() &&
            !book.getIsbn().matches("\\d{10,13}")) {
            throw new IllegalArgumentException(red("ISBN debe tener entre 10 y 13 dígitos."));
        }
    }
}
