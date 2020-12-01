package PocketScores;

/*
Last Updated: 12/1/2020

Description:
This is a controller class for the MenuSlidePane fxml file. The
MenuSlidePane fxml file is the file that contains a slide over pane,
which is shown in the NFLListView and NFLScoreBoard fxml files.
This controller class contain the methods needed for the MenuSlidePane
fxml file to function.

Contributing Author: Brandon Banner
 */
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuSlidePaneController implements Initializable {

    // Button to go to StartupView.fxml
    @FXML
    private JFXButton mainMenuButton;

    // Button to go to settings (not available)
    @FXML
    private JFXButton settingsButton;

    // Button to go to NFLListView.fxml
    @FXML
    private JFXButton gameListButton;

    // Method to initalize elements of menuSlidePane.fxml (unused)
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
    }

    // Method to handle mainMenuButton and open StartupView.fxml
    @FXML
    private void handleMainMenuButton(ActionEvent _event) {
        try {

            // Dislay StartupView.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PocketScores/StartupView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            PocketScores.window.setTitle("PocketScores");
            PocketScores.window.setScene(new Scene(root1));
            PocketScores.window.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method to handle gameListButton and open NFLListView.fxml
    @FXML
    private void handleGameListButton(ActionEvent _event) {
        try {

            // Display NFLListView.fxml
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
