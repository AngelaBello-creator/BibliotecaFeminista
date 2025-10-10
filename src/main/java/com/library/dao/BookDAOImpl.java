package com.library.dao;

import com.library.model.Book;
import com.library.model.Author;
import com.library.model.Genre;
import static com.library.util.ConsoleColor.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDao {

    @Override
    public void insert(Book book) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DatabaseConnection.init();
            String sql = "INSERT INTO books(title, author, description, isbn, genre) VALUES(?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthorsAsString());
            stmt.setString(3, book.getDescription());
            stmt.setString(4, book.getIsbn());
            stmt.setString(5, book.getGenresAsString());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(red("Error al crear libro: " + e.getMessage()));
        } finally {
            
            closeResources(connection, stmt, null);
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection connection = DatabaseConnection.init();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapResultSetToBook(rs));
            }
        } catch (Exception e) {
            System.out.println(red("Error al obtener libros: " + e.getMessage()));
        }
        return books;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection connection = DatabaseConnection.init();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    book = mapResultSetToBook(rs);
            }
        } catch (Exception e) {
            System.out.println(red("Error al buscar libro por ID: " + e.getMessage()));
        }
        return book;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return findByField("title", title);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return findByField("author", author);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return findByField("genre", genre);
    }

    private List<Book> findByField(String field, String value) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE " + field + " ILIKE ?";
        try (Connection connection = DatabaseConnection.init();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + value + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                    books.add(mapResultSetToBook(rs));
            }
        } catch (Exception e) {
            System.out.println(red("Error al buscar por " + field + ": " + e.getMessage()));
        }
        return books;
    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE books SET title=?, author=?, description=?, isbn=?, genre=? WHERE id=?";
        try (Connection connection = DatabaseConnection.init();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthorsAsString());
            stmt.setString(3, book.getDescription());
            stmt.setString(4, book.getIsbn());
            stmt.setString(5, book.getGenresAsString());
            stmt.setInt(6, book.getId());

            stmt.executeUpdate();
            System.out.println(green("Libro actualizado con éxito"));
        } catch (Exception e) {
            System.out.println(red("Error al actualizar libro: " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection connection = DatabaseConnection.init();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(red("Error al eliminar libro: " + e.getMessage()));
        }
    }

    private Book mapResultSetToBook(ResultSet rs) throws SQLException {
        Book book = new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("isbn"),
                rs.getString("description"));
        String authorName = rs.getString("author");
        if (authorName != null && !authorName.isEmpty()) {
            book.addAuthor(new Author(authorName));
        }
        String genreName = rs.getString("genre");
        if (genreName != null && !genreName.isEmpty()) {
            book.addGenre(new Genre(genreName));
        }
        return book;
    }

    private void closeResources(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println(red("Error al cerrar conexión: " + e.getMessage()));
        }
    }
}
