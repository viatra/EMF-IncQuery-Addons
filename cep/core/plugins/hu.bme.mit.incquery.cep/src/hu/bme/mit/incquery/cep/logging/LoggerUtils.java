package hu.bme.mit.incquery.cep.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerUtils {
    private static final String LOGGER_NAME = "cep.logger";
    private static LoggerUtils instance;
    private Logger logger;

    public static LoggerUtils getInstance() {
        if (instance == null) {
            instance = new LoggerUtils();
        }
        return instance;
    }

    private LoggerUtils() {
        this.logger = Logger.getLogger(LOGGER_NAME);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLevel(Level level) {
        logger.setLevel(level);
    }
}
