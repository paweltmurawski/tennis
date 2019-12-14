package com.tennis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector  {
    private Connection connection;
    private static DbConnector dbConnectorInstance;

    private DbConnector() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "paul_m");
        connectionProperties.put("password", "PcKt74j5");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis_center?serverTimezone=Europe/Warsaw" +
                "&useSSL=False", connectionProperties);
    }

    public static DbConnector getInstance() throws SQLException {
        if (dbConnectorInstance == null) {
            dbConnectorInstance = new DbConnector();
        }
            return dbConnectorInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
