package org.webonise.listapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbconnection = new DbConnection();

    private DbConnection() {
        // This is a Private Constructor to maintain only one instance.
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydatabase", "webonise", "12345678");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed.Check console");
            e.printStackTrace();
        }
        if (connection == null) {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public static Connection getConnection() {
        return dbconnection.createConnection();
    }
}

