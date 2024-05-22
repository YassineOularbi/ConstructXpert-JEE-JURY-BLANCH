package org.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String url = "jdbc:mysql://localhost:3306/construction_db";
    private static final String username = "root";
    private static final String password = "1234";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
