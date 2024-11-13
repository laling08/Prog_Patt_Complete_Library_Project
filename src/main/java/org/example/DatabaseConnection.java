package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:data.db";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
