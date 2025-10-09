package com.library.controller;

import com.library.dao.BookDao;
import com.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class LibraryControllerTest {

    private LibraryController controller;
    private BookDao mockDao;

    @BeforeEach
    void setUp() {
        mockDao = mock(BookDao.class);
        controller = new LibraryController(mockDao);
    }

    @Test
    void addBook_callsInsertOnDao() {
        Book book = new Book("El segundo sexo", "Simone de Beauvoir", "Obra clave", "1234567890", "Ensayo");
        controller.addBook(book);
        verify(mockDao, times(1)).insert(book);
    }

    @Test
    void addBook_throwsExceptionIfTitleEmpty() {
        Book book = new Book("", "Autora", "desc", "1234567890", "Ensayo");
        assertThrows(IllegalArgumentException.class, () -> controller.addBook(book));
        verify(mockDao, never()).insert(any());
    }
}
