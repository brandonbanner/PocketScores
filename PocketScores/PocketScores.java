package PocketScores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PocketScores extends Application {
    
    static Stage window;
    
    
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        PocketScores.window = primaryStage;
            
            Parent root = FXMLLoader.load(getClass().getResource("/PocketScores/StartupView.fxml"));
            primaryStage.setTitle("PocketScores");
            primaryStage.setScene(new Scene (root, 610, 400));
            primaryStage.show();
        
    }
}
