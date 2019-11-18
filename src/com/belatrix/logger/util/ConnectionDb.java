package com.belatrix.logger.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDb {

    private static final String USER_NAME = "";
    private static final String PASSWORD = "";
    private static final String DBMS = "";
    private static final String SERVER_NAME = "";
    private static final String PORT_NUMBER = "";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", USER_NAME);
        connectionProps.put("password", PASSWORD);

        connection = DriverManager.getConnection("jdbc:" + DBMS + "://" + SERVER_NAME
                + ":" + PORT_NUMBER + "/", connectionProps);
        return connection;
    }
}
