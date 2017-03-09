package com.darkestapp.raycasting.util;

import com.darkestapp.raycasting.interfaces.util.PropertyHelper;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public class RayCastingMainWindowSize extends PropertyHelper<String> {

    private int height;
    private int width;

    private static int DEFAULT_HEIGHT = 300;
    private static int DEFAULT_WIDTH = 500;

    private static String HEIGHT_STRING = "window.height";
    private static String WIDTH_STRING = "window.width";

    public RayCastingMainWindowSize() {

        try {

            height = Integer.valueOf(getProperty(HEIGHT_STRING));
            width = Integer.valueOf(getProperty(WIDTH_STRING));
        } catch (Exception e) {

            logger.info("Cannot get window size from file system, setting the default values");
            logger.debug(this.toString() + "\n" + e.getLocalizedMessage());
            height = DEFAULT_HEIGHT;
            width = DEFAULT_WIDTH;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
