
package PocketScores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FullListItemTemplateController implements Initializable {

    @FXML
    private HBox fullListItem;
    @FXML
    private Text gameDay;
    @FXML
    private Text gameDate;
    @FXML
    private Text gameTime;
    @FXML
    private Text visitorTeamName;
    @FXML
    private Text homeTeamName;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handlelistItem(MouseEvent event) {
        
         try{
            
           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/NFLScoreBoard.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("PocketScores: Current NFL Game");
                stage.setScene(new Scene(root1));
                stage.show();
                PocketScores.stg.close();
                
        } catch (Exception e){
            System.out.println(e);
        }
    }

    
    void setHomeTeamName (String txt){
        homeTeamName.setText(txt);
    }
    
    void setAwayTeamName (String txt){
        visitorTeamName.setText(txt);
    }
    
    void setGameTime (String txt){
        gameTime.setText(txt);
    }
    
    void setGameDate (String txt){
        gameDate.setText(txt);
    }
    
    void removeListItem (){
    }
}
