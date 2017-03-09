package com.darkestapp.raycasting.util;

import com.darkestapp.raycasting.exception.CannotGetPropertiesException;
import com.darkestapp.raycasting.interfaces.util.PropertyHelper;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public class RayCastingVersion extends PropertyHelper<String>{

    /**
     * Returns the version from properties file stored in resources
     * @return
     * @throws CannotGetPropertiesException
     */
    public String getVersion() throws CannotGetPropertiesException {

        return getProperty("version");
    }
}
