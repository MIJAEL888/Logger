package com.belatrix.logger.util;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CustomLoggerTest {



    @Test
    public void logInfoOnConsole() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.CONSOLE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info message on console.");
    }

    @Test
    public void logInfoOnFile() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.FILE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info message on file.");
    }
    @Test
    public void logInfoOnDataBase() {
        LoggerDataBase test = mock(LoggerDataBase.class);
        doNothing().when(test).logText(isA(String.class), isA(Level.class));
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.DATABASE);
        CustomLogger logger = new CustomLogger(loggerConfig, test);
        logger.logInfo("Info message on DB.");
    }

    @Test
    public void logErrorOnConsole() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.CONSOLE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info error on console.");
    }

    @Test
    public void logErrorOnFile() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.FILE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info error on file.");
    }
    @Test
    public void logErrorOnDataBase() {
        LoggerDataBase test = mock(LoggerDataBase.class);
        doNothing().when(test).logText(isA(String.class), isA(Level.class));
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.DATABASE);
        CustomLogger logger = new CustomLogger(loggerConfig, test);
        logger.logInfo("Info error on DB.");
    }

    @Test
    public void logWarningOnConsole() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.CONSOLE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info warning on console.");
    }

    @Test
    public void logWarningOnFile() {
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.FILE);
        CustomLogger logger = new CustomLogger(loggerConfig);
        logger.logInfo("Info warning on file.");
    }
    @Test
    public void logWarningDataBase() {
        LoggerDataBase test = mock(LoggerDataBase.class);
        doNothing().when(test).logText(isA(String.class), isA(Level.class));
        LoggerConfig loggerConfig =  new LoggerConfig();
        loggerConfig.addLevel(Level.INFO);
        loggerConfig.addAppender(Appender.DATABASE);
        CustomLogger logger = new CustomLogger(loggerConfig, test);
        logger.logInfo("Info warning on DB.");
    }
}