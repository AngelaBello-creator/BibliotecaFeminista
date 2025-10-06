package main.java.com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import main.java.com.library.dao.DatabaseConnection;

import main.java.com.library.model.Book;


public class BookDAOImpl implements BookDao {
    private Connection connection;
    private PreparedStatement stmn;

    @Override
    public void addBook(Book book){
        try{
            connection = DatabaseConnection.init();
            String sql = "INSERT INTO books(title, author, description, isbn, genre) VALUES(?, ?, ?, ?, ?)";
            stmn = connection.prepareStatement(sql);
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getAuthor());
            stmn.setString(3, book.getDescription());
            stmn.setString(4, book.getIsbn());
            stmn.setString(5, book.getGenre());

            stmn.executeUpdate();
            System.out.println(book.getTitle() + "ha sido create con éxito");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("No se ha podido crear");
        } finally{
            DatabaseConnection.close();
        }
    }

}
