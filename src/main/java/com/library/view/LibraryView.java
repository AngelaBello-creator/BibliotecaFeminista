package com.library.view;

import com.library.controller.LibraryController;
import com.library.model.Book;
import static com.library.util.ConsoleColor.*;

import java.util.InputMismatchException;
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
            printMainMenu();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                clearScreen();
                switch (option) {
                    case 1 -> showBooks();
                    case 2 -> addBook();
                    case 3 -> editBook();
                    case 4 -> deleteBook();
                    case 5 -> searchByTitle();
                    case 6 -> searchByAuthor();
                    case 7 -> searchByGenre();
                    case 0 -> printExitMessage();
                    default -> System.out.println(boldRed("Opcion no valida. Por favor, elige entre 0 y 7."));
                }
                if (option != 0) {
                    waitForUser();
                }
            } catch (InputMismatchException e) {
                System.out.println(boldRed("\nError: Por favor, introduce un numero valido"));
                scanner.nextLine();
                option = -1;
                waitForUser();
            }
        } while (option != 0);
        scanner.close();
    }

    private void printMainMenu() {
        clearScreen();
        System.out.println(boldMagenta("\n╔════════════════════════════════════════╗"));
        System.out.println(boldMagenta("║     BIBLIOTECA FEMINISTA - MENU        ║"));
        System.out.println(boldMagenta("╚════════════════════════════════════════╝"));
        System.out.println();
        System.out.println(brightCyan("  1.") + " Ver todos los libros");
        System.out.println(brightCyan("  2.") + " Anadir libro");
        System.out.println(brightCyan("  3.") + " Editar libro");
        System.out.println(brightCyan("  4.") + " Eliminar libro");
        System.out.println(brightCyan("  5.") + " Buscar por titulo");
        System.out.println(brightCyan("  6.") + " Buscar por autor");
        System.out.println(brightCyan("  7.") + " Buscar por genero");
        System.out.println();
        System.out.println(gray("  0.") + " Salir");
        System.out.println();
        System.out.print(brightYellow("Selecciona una opcion: "));
    }

    private void printSectionHeader(String title) {
        System.out.println(boldCyan("\n" + title));
        System.out.println(cyan("─".repeat(title.length())));
    }

    private void showBooks() {
        printSectionHeader("TODOS LOS LIBROS");
        List<Book> books = controller.getAllBooks();
        if (books.isEmpty()) {
            System.out.println(yellow("\nNo hay libros registrados en la biblioteca."));
        } else {
            System.out.println(gray("\nTotal de libros: " + books.size()));
            System.out.println();
            books.forEach(b -> System.out.println(formatBook(b)));
        }
    }

    private void addBook() {
        printSectionHeader("ANADIR NUEVO LIBRO");

        System.out.print(brightWhite("\nTitulo: "));
        String title = scanner.nextLine();

        System.out.print(brightWhite("Autor: "));
        String author = scanner.nextLine();

        System.out.print(brightWhite("Descripcion (max. 200 caracteres): "));
        String description = scanner.nextLine();

        System.out.print(brightWhite("ISBN: "));
        String isbn = scanner.nextLine();

        System.out.print(brightWhite("Genero: "));
        String genre = scanner.nextLine();

        try {
            Book book = new Book(title, author, description, isbn, genre);
            controller.addBook(book);
            System.out.println(boldGreen("\n" + title + " ha sido anadido con exito"));
        } catch (IllegalArgumentException e) {
            System.out.println(boldRed("\nError: " + e.getMessage()));
        }
    }

    private void editBook() {
        printSectionHeader("EDITAR LIBRO");
        System.out.print(brightWhite("\nIntroduce el ID del libro: "));
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            Book book = controller.getBookById(id);
            if (book == null) {
                System.out.println(boldRed("\nLibro no encontrado"));
                return;
            }
            System.out.println(gray("\nLibro actual:"));
            System.out.println(formatBookDetailed(book));
            System.out.println();
            System.out.print(brightWhite("Nuevo titulo (Enter para mantener): "));
            String newTitle = scanner.nextLine();
            if (!newTitle.isEmpty()) book.setTitle(newTitle);
            System.out.print(brightWhite("Nueva descripcion (Enter para mantener): "));
            String newDescription = scanner.nextLine();
            if (!newDescription.isEmpty()) book.setDescription(newDescription);
            System.out.print(brightWhite("Nuevo ISBN (Enter para mantener): "));
            String newIsbn = scanner.nextLine();
            if (!newIsbn.isEmpty()) book.setIsbn(newIsbn);
            controller.updateBook(book);
            System.out.println(boldGreen("\nLibro actualizado correctamente"));
        } catch (InputMismatchException e) {
            System.out.println(boldRed("\nError: Debes introducir un numero de ID valido"));
            scanner.nextLine();
        }
    }

    private void deleteBook() {
        printSectionHeader("ELIMINAR LIBRO");
        System.out.print(brightWhite("\nIntroduce el ID del libro: "));
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            Book book = controller.getBookById(id);
            if (book == null) {
                System.out.println(boldRed("\nLibro no encontrado"));
                return;
            }
            System.out.println(gray("\nLibro a eliminar:"));
            System.out.println(formatBookDetailed(book));
            System.out.print(brightYellow("\nEstas seguro? (s/n): "));
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("s") || confirm.equalsIgnoreCase("si")) {
                controller.deleteBook(id);
                System.out.println(boldGreen("\nLibro eliminado correctamente"));
            } else {
                System.out.println(yellow("\nOperacion cancelada"));
            }
        } catch (InputMismatchException e) {
            System.out.println(boldRed("\nError: Debes introducir un numero de ID valido"));
            scanner.nextLine();
        }
    }

    private void searchByTitle() {
        printSectionHeader("BUSCAR POR TITULO");
        System.out.print(brightWhite("\nIntroduce el titulo: "));
        String title = scanner.nextLine();
        Book book = controller.findByTitle(title);
        if (book != null) {
            System.out.println(gray("\nResultado de la busqueda:"));
            System.out.println(formatBookDetailed(book));
        } else {
            System.out.println(yellow("\nNo se encontro ningun libro con ese titulo"));
        }
    }

    private void searchByAuthor() {
        printSectionHeader("BUSCAR POR AUTOR");
        System.out.print(brightWhite("\nIntroduce el autor: "));
        String author = scanner.nextLine();
        List<Book> books = controller.findByAuthor(author);
        if (books.isEmpty()) {
            System.out.println(yellow("\nNo se encontraron libros de ese autor"));
        } else {
            System.out.println(gray("\nLibros encontrados: " + books.size()));
            System.out.println();
            books.forEach(b -> System.out.println(formatBook(b)));
        }
    }

    private void searchByGenre() {
        printSectionHeader("BUSCAR POR GENERO");
        System.out.print(brightWhite("\nIntroduce el genero: "));
        String genre = scanner.nextLine();
        List<Book> books = controller.findByGenre(genre);
        if (books.isEmpty()) {
            System.out.println(yellow("\nNo se encontraron libros en ese genero"));
        } else {
            System.out.println(gray("\nLibros encontrados: " + books.size()));
            System.out.println();
            books.forEach(b -> System.out.println(formatBook(b)));
        }
    }

    private String formatBook(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append(brightMagenta("ID: ")).append(book.getId());
        sb.append(gray(" | "));
        sb.append(boldCyan(book.getTitle()));
        sb.append(gray(" - "));
        sb.append(brightGreen(book.getAuthorsAsString()));
        String genres = book.getGenresAsString();
        if (!genres.isEmpty()) {
            sb.append(gray(" [")).append(brightYellow(genres)).append(gray("]"));
        }
        return sb.toString();
    }

    private String formatBookDetailed(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(brightMagenta("ID: ")).append(book.getId());
        sb.append("\n").append(brightCyan("Titulo: ")).append(book.getTitle());
        sb.append("\n").append(brightGreen("Autores: ")).append(book.getAuthorsAsString());
        sb.append("\n").append(brightYellow("Generos: ")).append(book.getGenresAsString());
        sb.append("\n").append(gray("ISBN: ")).append(book.getIsbn());
        String description = book.getDescription();
        if (description != null && !description.isEmpty()) {
            String cleanDescription = description.replaceAll("\\s+", " ").trim();
            sb.append("\n").append(gray("Descripcion: ")).append(cleanDescription);
        }
        return sb.toString();
    }

    private void printExitMessage() {
        clearScreen();
        System.out.println(boldMagenta("\n╔════════════════════════════════════════╗"));
        System.out.println(boldMagenta("║  Gracias por usar Biblioteca Feminista ║"));
        System.out.println(boldMagenta("╚════════════════════════════════════════╝\n"));
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void waitForUser() {
        System.out.println(gray("\n\nPresiona Enter para continuar..."));
        scanner.nextLine();
    }
}
