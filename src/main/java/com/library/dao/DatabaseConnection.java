package main.java.com.library.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "DB_URL";
    private static final String USER = "DB_USER";
    private static final String PASS = "DB_PASS";
    private static Connection connection;

    public static Connection init(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void close(){
        try{
            connection.close();
            System.out.println("Desconexión exitosa");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
