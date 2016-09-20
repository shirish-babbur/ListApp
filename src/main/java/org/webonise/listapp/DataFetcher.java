package org.webonise.listapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataFetcher {
    private Connection connection = null;

    public ResultSet getResultSet() throws SQLException {
        Statement statement = null;
        ResultSet resultset = null;
        connection = DbConnection.getConnection();
        statement = connection.createStatement();
        resultset = statement.executeQuery("SELECT * FROM Users;");
        return resultset;
    }

    public Users getData(ResultSet resultSet) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setAge(resultSet.getInt("age"));
        user.setLastName(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        user.setSalary(resultSet.getInt("salary"));
        return user;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
