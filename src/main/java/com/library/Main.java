package com.library;

import com.library.controller.LibraryController;
import com.library.dao.BookDao;
import com.library.dao.BookDAOImpl;
import com.library.view.LibraryView;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDAOImpl();
        LibraryController controller = new LibraryController(bookDao);
        LibraryView view = new LibraryView(controller);
        view.start();
    }
}
