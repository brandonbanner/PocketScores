package PocketScores;

/*
Last Updated: 12/1/2020

Description: This is the main class for entire project. It contains
the main method and the start method, which is used to launch the
program. It starts by launching the StartupView fxml file.

Contributing Author: Brandon Banner
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PocketScores extends Application {

    // Create instance of a Stage to be used throughout program
    protected static Stage window;

    // Main Method to launch application
    public static void main(String[] _args) {
        launch(_args);
    }

    // Method to start the program and display the first scene: StartupView.fxml
    @Override
    public void start(Stage _primaryStage) throws Exception {

        // Set overall Stage equal to primaryStage
        PocketScores.window = _primaryStage;

        // Display StartupView.fxml
        Parent root = FXMLLoader.load(getClass().getResource("/PocketScores/StartupView.fxml"));
        _primaryStage.setTitle("PocketScores");
        _primaryStage.setScene(new Scene(root, 615, 400));
        _primaryStage.show();

    }
}
