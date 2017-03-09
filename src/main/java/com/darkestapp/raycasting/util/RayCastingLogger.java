package com.darkestapp.raycasting.util;

import com.darkestapp.raycasting.exception.LoggerException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public class RayCastingLogger {

    private static final String LOG = "RayCastingLog";
    /**
     * Logger used in this class.
     */
    private Logger logger;

    /**
     * Default constructor
     * @param filePath
     * @throws LoggerException
     */
    public RayCastingLogger(String filePath) throws LoggerException {
        configLogger(filePath);
    }

    public RayCastingLogger() {
        logger = Logger.getLogger(LOG);
    }

    /**
     * Configures the logger and the file when the log will be stored.
     * @param filePath
     * @throws LoggerException
     */
    private void configLogger(String filePath) throws LoggerException {

        this.logger = Logger.getLogger(LOG);
        FileHandler fileHandler;

        try {

            // This block configure the logger with handler and formatter
            fileHandler = new FileHandler(filePath);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

        } catch (SecurityException e) {
            throw new LoggerException(
                    e,
                    "Creating a Logger",
                    "A security exception has occurred");
        } catch (IOException e) {
            throw new LoggerException(
                    e,
                    "Creating a Logger",
                    "A error with the file handled as occurred");
        }

    }

    /**
     * Log an info message
     * @param message
     */
    public void info(String message){
        logger.info(message);
    }

    /**
     * Log a warning message.
     * @param message
     */
    public void debug(String message){
        logger.warning(message);
    }

    /**
     * Creates a default Logger.
     * @return
     */
    public static RayCastingLogger getLogger(){
        try {
            return new RayCastingLogger(LOG);
        } catch (LoggerException e) {
            return new RayCastingLogger();
        }
    }
}
