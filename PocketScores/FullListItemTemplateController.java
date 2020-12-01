
package PocketScores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    static HBox fullListItem;
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
            Node source = (Node) event.getSource();
            System.out.println("Source ID: " + source.getId());
            NFLListViewController.gameNum = Integer.parseInt(source.getId());

           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/NFLScoreBoard.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PocketScores.window.setTitle("PocketScores: Current NFL Game");
                PocketScores.window.setScene(new Scene(root1));
                PocketScores.window.show();
                
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
        for (Node child: fullListItem.getChildren()){
            fullListItem.getChildren().clear();
        }
    }
}
