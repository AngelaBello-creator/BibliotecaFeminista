package com.library.dao;

import com.library.model.Book;
import java.util.List;

public interface BookDao {
    void insert(Book book);
    List<Book> findAll();
    Book findById(int id);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    void update(Book book);
    void delete(int id);
}
