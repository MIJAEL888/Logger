package com.belatrix.logger.util;

import java.util.ArrayList;
import java.util.List;

public class LoggerConfig {

    private static List<Level> levels = new ArrayList<>();
    private static List<Appender> appenders = new ArrayList<>();

    public static void setLevels(List<Level> levels) {
        LoggerConfig.levels = levels;
    }

    public void addLevel(Level level){
        LoggerConfig.levels.add(level);
    }

    public void addAppender(Appender appender){
        LoggerConfig.appenders.add(appender);
    }

    public boolean isLevelEnabled(Level level){
        for (Level levelAdded: levels) {
            if (levelAdded.equals(level)) return true;
        }
        return false;
    }

    public boolean isAppenderEnabled(Appender appender){
        for (Appender appenderAdded: appenders) {
        if (appenderAdded.equals(appender)) return true;
        }
        return false;
    }

    public boolean logOnDataBase(){
        for (Appender appender: appenders){
            if (appender.equals(Appender.DATABASE)) return true;
        }
        return false;
    }
}
