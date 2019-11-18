package com.belatrix.logger.util;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static com.belatrix.logger.util.Level.INFO;

public class CustomLogger {
    private static Logger logger = Logger.getLogger("MyLogger");
    private static final String FILE_NAME = "./MyLogger.log";
    private LoggerConfig loggerConfig;
    private LoggerDataBase loggerDataBase;

    public CustomLogger(LoggerConfig loggerConfig, LoggerDataBase loggerDataBase) {
        this.loggerConfig = loggerConfig;
        this.loggerDataBase = loggerDataBase;
        addAppenders();
    }

    public CustomLogger(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
        this.loggerDataBase = new LoggerDataBase();
        addAppenders();
    }

    public void logInfo(String messageText){
        this.log(messageText, INFO);
    }

    public void logError(String messageText){
        this.log(messageText, Level.ERROR);
    }

    public void logWarning(String messageText){
        this.log(messageText, Level.WARNING);
    }

    private void log(String messageText, Level level){
        if (!validText(messageText)) return;
        if (!loggerConfig.isLevelEnabled(level)) return;
        if (loggerConfig.logOnDataBase()) loggerDataBase.logText(messageText, level);
        switch (level){
            case INFO:
                logger.info(messageText);
                break;
            case ERROR:
                logger.severe(messageText);
                break;
            case WARNING:
                logger.warning(messageText);
                break;
            default:
                break;
        }
    }

    private void addAppenders(){
        if (loggerConfig.isAppenderEnabled(Appender.FILE)) addAppenderFile();
        if (loggerConfig.isAppenderEnabled(Appender.CONSOLE)) addAppendeConsole();
        //if (loggerConfig.isAppenderEnabled(Appender.DATABASE)) setLoggerDataBase();
    }

    private void addAppenderFile(){
        FileHandler fileHandler  = null;
        try {
            fileHandler = new FileHandler(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
    }

    private void addAppendeConsole(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
    }

    private boolean validText(String messageText){
        messageText.trim();
        if (messageText == null || messageText.length() == 0) return false;
        return true;
    }

}
