package org.webonise.listapp;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by webonise on 15/9/16.
 */
public class DbConnection {
    private static DbConnection dbconnection=new DbConnection();

    private DbConnection(){

    }
    private Connection createConnection(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection =DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/mydatabase", "webonise",
                    "12345678");

        } catch (Exception e) {

            System.out.println("Connection Failed.Check console");
            e.printStackTrace();
            return null;

        }

        if (connection == null){
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public static Connection getConnection(){
        return dbconnection.createConnection();
    }
}

