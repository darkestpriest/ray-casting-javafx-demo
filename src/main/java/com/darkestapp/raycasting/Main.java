package com.darkestapp.raycasting;

import com.darkestapp.raycasting.manager.AppManager;
import com.darkestapp.raycasting.util.RayCastingLogger;
import com.darkestapp.raycasting.util.RayCastingMainWindowSize;
import com.darkestapp.raycasting.util.RayCastingVersion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class to launch the app.
 * This app is a JavaFx app and uses Java 1.8+, please, review the build.gradle
 * to see the dependencies.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 09/03/17.
 */
public class Main extends Application {

    private static String VERSION = "";
    private final RayCastingLogger logger;
    private static final String TITLE = "Ray Casting Demo App ";

    /**
     * Default constructor.
     */
    public Main(){
        logger = RayCastingLogger.getLogger();
        try {
            VERSION = (new RayCastingVersion()).getVersion();
        } catch (Exception e){
            VERSION = "";
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Set the FXML file
        RayCastingMainWindowSize mainWindowSize = new RayCastingMainWindowSize();
        AppManager appManager = new AppManager();
        Scene scene = new Scene(
                appManager.getParent(),
                mainWindowSize.getWidth(),
                mainWindowSize.getHeight());

        primaryStage.setTitle(TITLE + VERSION);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();
    }

    /**
     * Main method
     * @param args arguments to start the app
     */
    public static void main(String[] args) {
        System.out.println("* Ray Casting App "+VERSION+" - 2016 *");
        System.out.println("* Source code at http://github.com/darkestpriest/ray-casting-demo *");
        //Launch the app
        launch(args);
    }
}
