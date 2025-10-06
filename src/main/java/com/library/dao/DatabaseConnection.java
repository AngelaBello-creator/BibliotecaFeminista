package com.library.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    private static String URL;
    private static String USER;
    private static String PASS;

    static {
        try {
            Properties props = new Properties();
            InputStream input = DatabaseConnection.class.getClassLoader()
                    .getResourceAsStream("database.properties");
            
            if (input == null) {
                System.out.println("No se pudo encontrar database.properties");
            } else {
                props.load(input);
                URL = props.getProperty("db.url");
                USER = props.getProperty("db.user");
                PASS = props.getProperty("db.password");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar configuración: " + e.getMessage());
        }
    }

    public static Connection init() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return connection;
    }
}