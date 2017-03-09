package com.darkestapp.raycasting.interfaces.util;

import com.darkestapp.raycasting.exception.CannotGetPropertiesException;
import com.darkestapp.raycasting.util.RayCastingLogger;
import com.darkestapp.raycasting.util.RayCastingVersion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public abstract class PropertyHelper<T> {

    public static final String CONFIG_PATH_FILE = "raycasting.properties";
    public static final RayCastingLogger logger = RayCastingLogger.getLogger();

    public T getProperty(String propertyName) throws CannotGetPropertiesException {

        Properties properties = new Properties();
        FileInputStream input = null;

        try {
            ClassLoader classLoader = RayCastingVersion.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(CONFIG_PATH_FILE);
            properties.load(inputStream);
            return (T) properties.getProperty(propertyName);
        } catch (IOException e) {
            logger.debug(e.getMessage());
            throw new CannotGetPropertiesException(
                    e,
                    "Getting version from "+CONFIG_PATH_FILE,
                    "There's is an I/O error");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new CannotGetPropertiesException(
                    e,
                    "Getting version from "+CONFIG_PATH_FILE,
                    "There's is an unexpected exception");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.debug(e.getMessage());
                    throw new CannotGetPropertiesException(
                            e,
                            "Getting version from "+CONFIG_PATH_FILE,
                            "There's is an I/O error");
                } catch (Exception e) {
                    logger.debug(e.getMessage());
                    throw new CannotGetPropertiesException(
                            e,
                            "Getting version from "+CONFIG_PATH_FILE,
                            "There's is an unexpected exception");
                }
            }
        }
    }
}
