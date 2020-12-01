package PocketScores;

/*
Last Updated: 12/1/2020

Description:
This is the controller class for the NFLScoreBoard fxml file. The NFLScoreBoard
fxml file displays a score board for a selected game, from the NFLListView fxml
file. This contoller contains the methods needed for the NFLScoreboard fxml file
to function.

Contributing Author: Brandon Banner
 */
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NFLScoreBoardController implements Initializable {

    @FXML
    private JFXHamburger navButton;

    @FXML
    private JFXDrawer menuDrawer;
    @FXML
    private Label homeOverallScore;
    @FXML
    private Text homeTeamName;
    @FXML
    private Label visitorOverallScore;
    @FXML
    private Text visitorTeamName;
    @FXML
    private Text gameTime;
    @FXML
    private Text homeQ1;
    @FXML
    private Text homeQ2;
    @FXML
    private Text homeQ3;
    @FXML
    private Text homeQ4;
    @FXML
    private Text qtr;
    @FXML
    private Text visitorQ1;
    @FXML
    private Text visitorQ2;
    @FXML
    private Text visitorQ3;
    @FXML
    private Text visitorQ4;
    @FXML
    private Text gameStatus;

    //Create item to call on NFL List View
    protected NFLListViewController viewInfo = new NFLListViewController();

    // Create instance of NFL Model
    protected NFLModel nflModel = new NFLModel(StartupViewController.date);

    // Menu Sliding Drawer
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setHomeOverallScore(this.nflModel.getHomeScore(NFLListViewController.gameNum));
        setHomeTeamName(this.nflModel.getHomeTeam(NFLListViewController.gameNum));
        setVisitorOverallScore(this.nflModel.getAwayScore(NFLListViewController.gameNum));
        setVisitorTeamName(this.nflModel.getAwayTeam(NFLListViewController.gameNum));
        setGameTime(this.nflModel.getRemainingTime(NFLListViewController.gameNum));
        setHomeQ1(this.nflModel.getFirstHomeQuarter(NFLListViewController.gameNum));
        setHomeQ2(this.nflModel.getSecondHomeQuarter(NFLListViewController.gameNum));
        setHomeQ3(this.nflModel.getThirdHomeQuarter(NFLListViewController.gameNum));
        setHomeQ4(this.nflModel.getFourthHomeQuarter(NFLListViewController.gameNum));
        setQtr(this.nflModel.getCurrentQuarter(NFLListViewController.gameNum));
        setVisitorQ1(this.nflModel.getFirstAwayQuarter(NFLListViewController.gameNum));
        setVisitorQ2(this.nflModel.getSecondAwayQuarter(NFLListViewController.gameNum));
        setVisitorQ3(this.nflModel.getThirdAwayQuarter(NFLListViewController.gameNum));
        setVisitorQ4(this.nflModel.getFourthAwayQuarter(NFLListViewController.gameNum));
        setGameStatus(this.nflModel.getStatus(NFLListViewController.gameNum));

        try {
            //Set up Slide Pane
            PocketScores.window.close();
            VBox slidePane = FXMLLoader.load(getClass().getResource("MenuSlidePane.fxml"));
            menuDrawer.setSidePane(slidePane);

        } catch (IOException _ex) {
            Logger.getLogger(NFLListViewController.class.getName()).log(Level.SEVERE, null, _ex);
        }
        //Nav button transition animation
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(navButton);

        // Nav button click event
        navButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            //  To close drawer if open, otherwise open drawer
            if (menuDrawer.isOpened()) {
                menuDrawer.close();
            } else {
                menuDrawer.open();
            }
        });

    }

//=================  GETTERS ===============
    // Method to get home overall score
    private String getHomeOverallScore() {
        return this.nflModel.getHomeScore(NFLListViewController.gameNum);
    }

// Method to get home team name
    private String getHomeTeamName() {
        return this.nflModel.getHomeTeam(NFLListViewController.gameNum);
    }

// Method to get home team Q1 score
    private String getHomeQ1() {
        return this.nflModel.getFirstHomeQuarter(NFLListViewController.gameNum);
    }

// Method to get home team Q2 score
    private String getHomeQ2() {
        return this.nflModel.getSecondHomeQuarter(NFLListViewController.gameNum);
    }

// Method to get home team Q3 score
    private String getHomeQ3() {
        return this.nflModel.getThirdHomeQuarter(NFLListViewController.gameNum);
    }

// Method to get home team Q4 score
    private String getHomeQ4() {
        return this.nflModel.getFourthHomeQuarter(NFLListViewController.gameNum);
    }

// Method to get visitor overall score
    private String getVisitorOverallScore() {
        return this.nflModel.getAwayScore(NFLListViewController.gameNum);
    }

// Method to get visitor team name
    private String getVisitorTeamName() {
        return this.nflModel.getAwayTeam(NFLListViewController.gameNum);
    }

// Method to get vistor Q1 score
    private String getVistiorQ1() {
        return this.nflModel.getFirstAwayQuarter(NFLListViewController.gameNum);
    }

// Method to get visitor Q2 score
    private String getVisitorQ2() {
        return this.nflModel.getSecondAwayQuarter(NFLListViewController.gameNum);
    }

// Method to get visitor Q3 score
    private String getVisitorQ3() {
        return this.nflModel.getThirdAwayQuarter(NFLListViewController.gameNum);
    }

// Method to get visitor Q4 score
    private String getVisitorQ4() {
        return this.nflModel.getFourthAwayQuarter(NFLListViewController.gameNum);
    }

// Method to get game status
    private String getGameStatus() {
        return this.nflModel.getStatus(NFLListViewController.gameNum);
    }

// Method to get current quarter
    private String getQtr() {
        return this.nflModel.getCurrentQuarter(NFLListViewController.gameNum);
    }

    // Method to get time remaining of quarter
    private String getGameTime() {
        return this.nflModel.getRemainingTime(NFLListViewController.gameNum);
    }

//=================  SETTERS ===============
    // Method to set the home team's overall score
    private void setHomeOverallScore(String _score) {
        homeOverallScore.setText(_score);
    }

    // Method to set home team's name
    private void setHomeTeamName(String _name) {
        homeTeamName.setText(_name);
    }

    // Method to set Q1 score for home team
    private void setHomeQ1(String _score) {
        homeQ1.setText("Q1: " + _score);
    }

    // Method to set Q2 score for home team
    private void setHomeQ2(String _score) {
        homeQ2.setText("Q2: " + _score);
    }

    // Method to set Q3 score for home team
    private void setHomeQ3(String _score) {
        homeQ3.setText("Q3: " + _score);
    }

    // Method to set Q4 score for home team
    private void setHomeQ4(String _score) {
        homeQ4.setText("Q4: " + _score);
    }

    //Method to set the visitor team's overall score
    private void setVisitorOverallScore(String _score) {
        visitorOverallScore.setText(_score);
    }
    // Method to set visitor team's name

    private void setVisitorTeamName(String _name) {
        visitorTeamName.setText(_name);
    }

    // Method to set Q1 score for visitor team
    private void setVisitorQ1(String _score) {
        visitorQ1.setText("Q1: " + _score);
    }

    // Method to set Q2 score for visitor team
    private void setVisitorQ2(String _score) {
        visitorQ2.setText("Q2: " + _score);
    }

    // Method to set Q3 score for visitor team
    private void setVisitorQ3(String _score) {
        visitorQ3.setText("Q3: " + _score);
    }

    // Method to set Q4 score for visitor team
    private void setVisitorQ4(String _score) {
        visitorQ4.setText("Q4: " + _score);
    }

    // Method to set current quarter
    private void setQtr(String _quarter) {
        qtr.setText(_quarter);
    }

    // Method to set quarter time remaining
    private void setGameTime(String _time) {
        gameTime.setText(_time);
    }

    // Method to set game status
    private void setGameStatus(String _status) {
        if ("final".equals(_status) || " final ".equals(_status)) {
            gameStatus.setText("Game Status: FINAL");
        } else if ("in progress".equals(_status) || " in progress ".equals(_status)) {
            gameStatus.setText("Game Status: In Progress");
        } else if ("canceled".equals(_status) || " canceled ".equals(_status)) {
            gameStatus.setText("Game Status: Cancelled");
        } else {
            gameStatus.setText("Game Status: Scheduled");
        }
    }
}
