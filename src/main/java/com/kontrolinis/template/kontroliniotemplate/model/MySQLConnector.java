package com.kontrolinis.template.kontroliniotemplate.model;

import java.sql.*;

public class MySQLConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/products";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public MySQLConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String query) {
        int rowsAffected = 0;
        try {
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Create
    public int insert(String tableName, String[] columns, String[] values) {
        if (columns.length != values.length) {
            System.err.println("Number of columns and values do not match");
            return 0;
        }

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName).append(" (");

        for (int i = 0; i < columns.length; i++) {
            queryBuilder.append(columns[i]);
            if (i < columns.length - 1) {
                queryBuilder.append(", ");
            }
        }

        queryBuilder.append(") VALUES (");

        for (int i = 0; i < values.length; i++) {
            queryBuilder.append("'").append(values[i]).append("'");
            if (i < values.length - 1) {
                queryBuilder.append(", ");
            }
        }

        queryBuilder.append(")");

        return executeUpdate(queryBuilder.toString());
    }

    // Read
    public ResultSet selectAll(String tableName) {
        return executeQuery("SELECT * FROM " + tableName);
    }

    // Update
    public int update(String tableName, String setColumn, String setValue, String conditionColumn, String conditionValue) {
        String query = "UPDATE " + tableName + " SET " + setColumn + "='" + setValue + "' WHERE " + conditionColumn + "='" + conditionValue + "'";
        return executeUpdate(query);
    }

    // Delete
    public int delete(String tableName, String conditionColumn, String conditionValue) {
        String query = "DELETE FROM " + tableName + " WHERE " + conditionColumn + "='" + conditionValue + "'";
        return executeUpdate(query);
    }
}
