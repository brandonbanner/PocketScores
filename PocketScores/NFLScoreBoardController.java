/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    

    
    // Menu Sliding Drawer
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PocketScores.stg.close();
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
    

    
    }}
