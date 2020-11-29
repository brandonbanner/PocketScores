package PocketScores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartupViewController implements Initializable {

    @FXML
    private Button nflButton;
    
    @FXML
    private Button nbaButton;
    
    @FXML
    private Button mlbButton;
    
    @FXML
    private Button mlsButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    void handleNFLButton(ActionEvent event) {
        try{
            
           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/NFLListView.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("PocketScores: NFL");
                stage.initStyle(StageStyle.DECORATED);
                stage.setScene(new Scene(root1));
                stage.show();
                PocketScores.stg.close();
                
        } catch (Exception e){
            System.out.println(e);
        }
        }
    } 
