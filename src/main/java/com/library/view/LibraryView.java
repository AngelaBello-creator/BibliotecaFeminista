package com.library.view;

import com.library.controller.LibraryController;
import com.library.model.entities.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryView {

    private final LibraryController controller;
    private final Scanner scanner;

    public LibraryView(LibraryController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        do {
            System.out.println("\n===== Biblioteca Feminista =====");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Añadir libro");
            System.out.println("3. Editar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Buscar libro por título");
            System.out.println("6. Buscar libros por autor");
            System.out.println("7. Buscar libros por género");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1 -> showBooks();
                case 2 -> addBook();
                case 3 -> editBook();
                case 4 -> deleteBook();
                case 5 -> searchByTitle();
                case 6 -> searchByAuthor();
                case 7 -> searchByGenre();
                case 0 -> System.out.println("Gracias por usar la Biblioteca Feminista");
                default -> System.out.println("Opción no válida");
            }

        } while (option != 0);
        
        scanner.close();
    }

    private void showBooks() {
        List<Book> books = controller.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Book b : books) {
                System.out.println("ID: " + b.getId() +
                                   ", Título: " + b.getTitle() +
                                   ", Autor: " + b.getAuthor() +
                                   ", ISBN: " + (b.getIsbn() != null ? b.getIsbn() : "N/A") +
                                   ", Género: " + b.getGenre());
            }
        }
    }

    private void addBook() {
        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Autor: ");
        String author = scanner.nextLine();

        System.out.print("Descripción (máx. 200): ");
        String description = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Género: ");
        String genre = scanner.nextLine();

        Book book = new Book(title, author, description, isbn, genre);
        controller.addBook(book);
        System.out.println("Libro añadido con éxito");
    }

    private void editBook() {
        System.out.print("Introduce el ID del libro a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nuevo título: ");
        String newTitle = scanner.nextLine();

        controller.updateBook(id, newTitle);
        System.out.println("Libro actualizado");
    }

    private void deleteBook() {
        System.out.print("Introduce el ID del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        controller.deleteBook(id);
        System.out.println("Libro eliminado");
    }

    private void searchByTitle() {
        System.out.print("Introduce título: ");
        String title = scanner.nextLine();
        Book book = controller.findByTitle(title);
        if (book != null) {
            System.out.println(book.toString());
        } else {
            System.out.println("No se encontró ningún libro con ese título");
        }
    }

    private void searchByAuthor() {
        System.out.print("Introduce autor: ");
        String author = scanner.nextLine();
        List<Book> books = controller.findByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros de ese autor");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    private void searchByGenre() {
        System.out.print("Introduce género: ");
        String genre = scanner.nextLine();
        List<Book> books = controller.findByGenre(genre);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros en ese género");
        } else {
            for (Book b : books) {
                System.out.println("Título: " + b.getTitle() +
                                   ", Autor: " + b.getAuthor() +
                                   ", ISBN: " + b.getIsbn() +
                                   ", Género: " + b.getGenre());
            }
        }
    }
}