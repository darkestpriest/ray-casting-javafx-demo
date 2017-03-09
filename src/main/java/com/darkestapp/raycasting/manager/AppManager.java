package com.darkestapp.raycasting.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public class AppManager {

    /**
     * Represents the main view
     */
    private final static String MAIN_FXML = "/fxml/Main.fxml";
    /**
     * Main parent from the view
     */
    private final Parent root;

    public AppManager() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_FXML));
        root = loader.load();
    }

    /**
     * This method returns the main parent
     * @return the main parent for the app
     */
    public Parent getParent() {
        return root;
    }
}
