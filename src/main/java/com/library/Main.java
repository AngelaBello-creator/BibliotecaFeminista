package com.library;

import com.library.controller.LibraryController;
import com.library.model.dao.BookDAOImpl;
import com.library.view.LibraryView;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  BIBLIOTECA FEMINISTA - Sistema de Gestión");
        System.out.println("===========================================\n");

        try {
            LibraryView view = new LibraryView();
            BookDAOImpl bookDAO = new BookDAOImpl();
            LibraryController controller = new LibraryController(view, bookDAO);

            controller.start();

        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}