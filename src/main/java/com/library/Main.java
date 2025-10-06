package com.library;

import com.library.controller.LibraryController;
import com.library.model.dao.BookDAO;
import com.library.model.dao.BookDAOImpl;
import com.library.view.LibraryView;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del DAO
        BookDAO bookDAO = new BookDAOImpl();
        
        // Crear instancia del controlador
        LibraryController controller = new LibraryController(bookDAO);
        
        // Crear instancia de la vista
        LibraryView view = new LibraryView(controller);
        
        // Iniciar la aplicación
        view.start();
    }
}