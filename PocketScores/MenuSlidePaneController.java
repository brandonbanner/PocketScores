
package PocketScores;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MenuSlidePaneController implements Initializable {

    @FXML
    private JFXButton mainMenuButton;
    @FXML
    private JFXButton settingsButton;
    @FXML
    private JFXButton gameListButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMainMenuButton(ActionEvent event) {
        try{
            
           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/StartupView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PocketScores.window.setTitle("PocketScores");
                PocketScores.window.setScene(new Scene(root1));
                PocketScores.window.show();
                
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void handleGameListButton(ActionEvent event) {
         try{
            
           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/NFLListView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PocketScores.window.setTitle("PocketScores: NFL");
                PocketScores.window.setScene(new Scene(root1));
                PocketScores.window.show();
                
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
