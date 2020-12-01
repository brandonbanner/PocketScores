package PocketScores;

/*
Last updated: 12/1/2020

Description:
This is a controller class for the FullListItemTemplate fxml file. The FullListItem
fxml file contains a template for a game list item, which is then shown on
the NFLListView fxml file, then popuated accordingly. This controller contains
the methods needed for the FullListItemTemplate fxml file to function.

Contributing Authors: Brandon Banner, George Bell, and Clayton Winters
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FullListItemTemplateController implements Initializable {

    // HBox that contains the following items to be displayed in NFLListView.fxml
    @FXML
    protected static HBox fullListItem;

    // Day of week of the game
    @FXML
    private Text gameDay;

    // Date of the game
    @FXML
    private Text gameDate;

    // Start time of game
    @FXML
    private Text gameTime;

    // Name of visitor (away) team
    @FXML
    private Text visitorTeamName;

    // Name of home team
    @FXML
    private Text homeTeamName;

    // Method to initalize elements of FullListItemTemplate.fxml (unused)
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
    }

    // Method to open NFLScoreBoard once a list item is clicked
    @FXML
    private void handleListItem(MouseEvent _event) {

        try {
            // Create a node to get source of click (fullListItem)
            Node source = (Node) _event.getSource();
            // Set ID number of fullListItem that was clicked to gameNum
            NFLListViewController.gameNum = Integer.parseInt(source.getId());

            // Display NFLScoreBoard.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PocketScores/NFLScoreBoard.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            PocketScores.window.setTitle("PocketScores: Current NFL Game");
            PocketScores.window.setScene(new Scene(root1));
            PocketScores.window.show();

        } catch (Exception _e) {
            System.out.println(_e);
        }
    }

    //=================  SETTERS ==============
    protected void setHomeTeamName(String _txt) {
        homeTeamName.setText(_txt);
    }

    protected void setAwayTeamName(String _txt) {
        visitorTeamName.setText(_txt);
    }

    protected void setGameTime(String _txt) {
        gameTime.setText(_txt);
    }

    protected void setGameDate(String _txt) {
        gameDate.setText(_txt);
    }
}
