package com.belatrix.logger;

import com.belatrix.logger.util.Appender;
import com.belatrix.logger.util.Level;
import com.belatrix.logger.util.CustomLogger;
import com.belatrix.logger.util.LoggerConfig;

public class Main {

    public static void main(String[] args) {

        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.ERROR);
        loggerConfig.addLevel(Level.WARNING);
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.CONSOLE);
        //loggerConfig.addAppender(Appender.DATABASE);
        loggerConfig.addAppender(Appender.FILE);

        CustomLogger logger = new CustomLogger(loggerConfig);

        logger.logError("Error message.");
        logger.logInfo("Info message.");
        logger.logWarning("Warning message.");
    }
}
