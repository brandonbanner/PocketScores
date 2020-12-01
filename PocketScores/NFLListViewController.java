package PocketScores;

/*
Last Updated: 12/1/2020

Description:
This is the controller class for the NFLListView fxml file. The NFLListView
fxml file displays a list of NFL games and allows the user to display games
based upon a selected date. This controller provides the methods needed
for the NFLListView fxml file to function.

Contributing Authors: Brandon Banner, George Bell, and Clayton Winters
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class NFLListViewController implements Initializable {

    // Pane that fullListItem(s) will be displayed on
    @FXML
    private Pane listBase;

    // Button to open MenuSlidePane.fxml
    @FXML
    private JFXHamburger navButton;

    // Area where menuSlidePane.fxml will display
    @FXML
    private JFXDrawer menuDrawer;

    // Scrollable pane for the window
    @FXML
    private ScrollPane backdrop;

    // Date Picker for choosing date of game
    @FXML
    private DatePicker datePicker;

    // Game ID number
    protected static int gameNum;

    // Instance of NFLModel that'll be equal to the date set
    protected NFLModel nflModel = new NFLModel(StartupViewController.date);

    // Node to hold fullListItem (game)
    protected Node fullListItem;

    // ArrayList to hold fullListItem nodes
    protected ArrayList<Node> allNodes = new ArrayList<Node>();

    // Method to set up file (scroll type and menu slide pane)
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set scroll preferences
        backdrop.setContent(listBase);
        backdrop.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        backdrop.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Call to genListItem based upon the number of games provided by nflModel
        genListItem(this.nflModel.getNumGames());

        try {
            // Set up menuSlidePane
            VBox slidePane = FXMLLoader.load(getClass().getResource("MenuSlidePane.fxml"));
            menuDrawer.setSidePane(slidePane);
            menuDrawer.styleProperty();
        } catch (IOException _ex) {
            Logger.getLogger(NFLListViewController.class.getName()).log(Level.SEVERE, null, _ex);
        }
        // Nav button transition animation
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(navButton);
        // Nav button click event
        navButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            //To close the navigation drawer (menuSlidePane) if open
            if (menuDrawer.isOpened()) {
                menuDrawer.close();
            } else {
                // To iniitally open navigation drawer (menuSlidePane)
                menuDrawer.open();
            }
        });
    }

    // Set up spacing of HBoxes to be generated, placed every 84 pixels
    public void genListItem(int _numGames) {
        for (int i = 0, x = 42, y = 84, g = 1; i < _numGames && g <= _numGames; i++, y += 84, g++) {
            // Call to generate HBoxes
            genFullListItem(x, y, g);
        }
    }

    // Open ScoreBoard.fxml when list item is clicked
    private void handleListItem(MouseEvent _event) {
        try {
            // Create node to get source (fullListItem ID) of click event
            Node source = (Node) _event.getSource();
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

    // Generate HBoxes from FullListItemTemplate.fxml and put on listBase
    private void genFullListItem(int _x, int _y, int _g) {
        FXMLLoader loader = new FXMLLoader();

        try {
            Node fli = loader.load(getClass().getResource("FullListItemTemplate.fxml").openStream());
            listBase.getChildren().add(fli);
            fli.setId("" + _g);
            fli.setLayoutX(_x);
            fli.setLayoutY(_y);
            fli.toBack();
            fullListItem = fli;
            this.allNodes.add(fli);

            // Get Controller for FullListItemTemplate to set home team name
            FullListItemTemplateController homeTeamName = (FullListItemTemplateController) loader.getController();
            homeTeamName.setHomeTeamName(nflModel.getHomeTeam(_g));

            // Get Controller for FullListItemTemplate to set visitor team name
            FullListItemTemplateController visitorTeamName = (FullListItemTemplateController) loader.getController();
            visitorTeamName.setAwayTeamName(nflModel.getAwayTeam(_g));

            // Get Controller for FullListItemTemplate to set start time of game
            FullListItemTemplateController gameTime = (FullListItemTemplateController) loader.getController();
            gameTime.setGameTime(nflModel.getStartTime(_g));

            // Get Controller for FullListItemTemplate to set date of game
            FullListItemTemplateController gameDate = (FullListItemTemplateController) loader.getController();
            gameDate.setGameDate(StartupViewController.date);

        } catch (IOException _ex) {
            _ex.printStackTrace();
        }
    }

    /* Method to remove existing list items from page, and display new list items
    based upon new, selected date. Date is then stored as date to be refferenced
    for NFLScoreBoard.fxml
     */
    @FXML
    private void handleDate(ActionEvent _event) {
        // Remove existing list items
        for (Node listNode : this.allNodes) {
            listBase.getChildren().remove(listNode);
        }
        // Set new date
        LocalDate thedate = datePicker.getValue();
        StartupViewController.date = String.valueOf(thedate);
        nflModel = new NFLModel(StartupViewController.date);
        genListItem(nflModel.getNumGames());
    }
}
