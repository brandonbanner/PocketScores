package PocketScores;

/*
Last Updated: 12/1/2020

Description:
This is the controller class for the StartupView fxml file. The StartupView
fxml file displays the inital view, which has buttons for selecting a sport.
This controller contains the methods needed for the StartupView file function.

Contributing Authors: Brandon Banner and George Bell
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StartupViewController implements Initializable {

    // Button to bring to NFLListView.fxml
    @FXML
    private Button nflButton;

    // Button to bring to NBAListView.fxml (not included)
    @FXML
    private Button nbaButton;

    // Button to bring to MLBListView.fxml (not included)
    @FXML
    private Button mlbButton;

    // Button to bring to MLSListView.fxml (not inluded)
    @FXML
    private Button mlsButton;

    // String to initalize date to be used throughout program
    protected static String date = "";

    // Used to inialize elements of the file
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
    }

    // Method that switches to the NFLListView scene after nflButton is clicked
    @FXML
    private void handleNFLButton(ActionEvent _event) {

        try {

            //Display NFLListView.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PocketScores/NFLListView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            PocketScores.window.setTitle("PocketScores: NFL");
            PocketScores.window.setScene(new Scene(root1));
            PocketScores.window.show();

        } catch (Exception _e) {
            System.out.println(_e);
        }
    }
}
