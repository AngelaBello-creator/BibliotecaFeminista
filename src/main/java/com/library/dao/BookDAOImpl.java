package com.library.dao;

import com.library.model.entities.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.library.dao.DatabaseConnection;
import com.library.dao.BookDAO;

public class BookDAOImpl implements BookDAO {

    @Override
    public void insert(Book book) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "INSERT INTO books(title, author, description, isbn, genre) VALUES(?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getDescription());
            stmt.setString(4, book.getIsbn());
            stmt.setString(5, book.getGenre());

            stmt.executeUpdate();
            System.out.println(book.getTitle() + " ha sido añadido con éxito");
        } catch (Exception e) {
            System.out.println("Error al crear libro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    @java.lang.Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "SELECT * FROM books";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("genre")
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener libros: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return books;
    }

    @java.lang.Override
    public Book findById(int id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "SELECT * FROM books WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("genre")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar libro por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return book;
    }

    @Override
    @Override
    public List<Book> findByTitle(String title) {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "SELECT * FROM books WHERE title LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + title + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("genre")
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por título: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "SELECT * FROM books WHERE author LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + author + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("genre")
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por autor: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return books;
    }

    @Override
    public List<Book> findByGenre(String genre) {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "SELECT * FROM books WHERE genre LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + genre + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("genre")
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por género: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return books;
    }

    @Override
    public void update(Book book) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "UPDATE books SET title = ?, author = ?, description = ?, isbn = ?, genre = ? WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getDescription());
            stmt.setString(4, book.getIsbn());
            stmt.setString(5, book.getGenre());
            stmt.setInt(6, book.getId());

            stmt.executeUpdate();
            System.out.println("Libro actualizado con éxito");
        } catch (Exception e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "DELETE FROM books WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Libro eliminado con éxito");
        } catch (Exception e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}