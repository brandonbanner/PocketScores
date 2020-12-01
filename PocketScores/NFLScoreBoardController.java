package PocketScores;

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
    NFLListViewController viewInfo = new NFLListViewController();

    // Create instance of NFL Model
    NFLModel nflModel = new NFLModel (StartupViewController.date);
    
    
    // Menu Sliding Drawer
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        homeOverallScore.setText(nflModel.getHomeScore(NFLListViewController.gameNum));
        homeTeamName.setText(nflModel.getHomeTeam(NFLListViewController.gameNum));
        visitorOverallScore.setText(nflModel.getAwayScore(NFLListViewController.gameNum));
        visitorTeamName.setText(nflModel.getAwayTeam(NFLListViewController.gameNum));
        gameTime.setText(nflModel.getRemainingTime(NFLListViewController.gameNum));
        homeQ1.setText("Q1: " + nflModel.getFirstHomeQuarter(NFLListViewController.gameNum));
        homeQ2.setText("Q2: " + nflModel.getSecondHomeQuarter(NFLListViewController.gameNum));
        homeQ3.setText("Q3: " + nflModel.getThirdHomeQuarter(NFLListViewController.gameNum));
        homeQ4.setText("Q4: " + nflModel.getFourthHomeQuarter(NFLListViewController.gameNum));
        qtr.setText(nflModel.getCurrentQuarter(NFLListViewController.gameNum));
        visitorQ1.setText("Q1: " + nflModel.getFirstAwayQuarter(NFLListViewController.gameNum));
        visitorQ2.setText("Q2: " + nflModel.getSecondAwayQuarter(NFLListViewController.gameNum));
        visitorQ3.setText("Q3: " + nflModel.getThirdAwayQuarter(NFLListViewController.gameNum));
        visitorQ4.setText("Q4: " + nflModel.getFourthAwayQuarter(NFLListViewController.gameNum));
        gameStatus.setText("Game Status: " + nflModel.getStatus(NFLListViewController.gameNum));
        
        try {
            PocketScores.window.close();
            VBox slidePane = FXMLLoader.load(getClass().getResource("menuSlidePane.fxml"));
            
            menuDrawer.setSidePane(slidePane);
           
            
        } catch (IOException ex) {
            Logger.getLogger(NFLListViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Nav button transition animation
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(navButton);
        
        // Nav button click event
        navButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
            
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(menuDrawer.isOpened())
                
                menuDrawer.close(); //To close the navigation drawer
                
            else{
                
                menuDrawer.open(); // To iniitally open navigation drawer
              
            }
        });
    

    
    } 
}
