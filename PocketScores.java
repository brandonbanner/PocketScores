package PocketScores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PocketScores extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    static Stage stg;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        PocketScores.stg = stage;
            
            Parent root = FXMLLoader.load(getClass().getResource("/PocketScores/StartupView.fxml"));
            stage.setTitle("PocketScores");
            stage.setScene(new Scene (root, 600, 400));
            stage.show();
        
    }
}
