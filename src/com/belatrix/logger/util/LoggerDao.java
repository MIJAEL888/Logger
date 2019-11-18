package com.belatrix.logger.util;


import java.sql.SQLException;
import java.sql.Statement;

public class LoggerDao {

    public void logText(String messageText, Level level) {
        try {
            Statement stmt = ConnectionDb.getConnection().createStatement();
            stmt.executeUpdate("insert into Log_Values('" + messageText + "', " + level.name() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
