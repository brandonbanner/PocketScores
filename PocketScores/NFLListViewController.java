package PocketScores;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NFLListViewController implements Initializable {

    // Items
    @FXML
    private Pane listBase;
    
    @FXML
    private VBox fullListItem;
    
    @FXML
    private JFXHamburger navButton;
    
    @FXML
    private JFXDrawer menuDrawer;
    
    @FXML
    private JFXComboBox monthBox;
    
    @FXML
    private JFXComboBox dayBox;
    
    @FXML
    private JFXComboBox  yearBox;
    
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

   // Menu Sliding Drawer
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try {
           
            VBox slidePane = FXMLLoader.load(getClass().getResource("menuSlidePane.fxml"));
            
            menuDrawer.setSidePane(slidePane);
            menuDrawer.styleProperty();
           
            
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
        
        // Month comboBox items
         monthBox.getItems().add("January");
         monthBox.getItems().add("February");
         monthBox.getItems().add("March");
         monthBox.getItems().add("April");
         monthBox.getItems().add("May");
         monthBox.getItems().add("June");
         monthBox.getItems().add("July");
         monthBox.getItems().add("August");
         monthBox.getItems().add("September");
         monthBox.getItems().add("October");
         monthBox.getItems().add("November");
         monthBox.getItems().add("December");
                
        //Day comboBox items
        
        /* for (int day = 0; day <= 31; day++){
            monthBox.getItems().add("" + day);
        }*/
        
        dayBox.getItems().add("1");
        dayBox.getItems().add("2");
        dayBox.getItems().add("3");
        dayBox.getItems().add("4");
        dayBox.getItems().add("5");
        dayBox.getItems().add("6");
        dayBox.getItems().add("7");
        dayBox.getItems().add("8");
        dayBox.getItems().add("9");
        dayBox.getItems().add("10");
        dayBox.getItems().add("11");
        dayBox.getItems().add("12");
        dayBox.getItems().add("13");
        dayBox.getItems().add("14");
        dayBox.getItems().add("15");
        dayBox.getItems().add("16");
        dayBox.getItems().add("17");
        dayBox.getItems().add("18");
        dayBox.getItems().add("19");
        dayBox.getItems().add("20");
        dayBox.getItems().add("21");
        dayBox.getItems().add("22");
        dayBox.getItems().add("23");
        dayBox.getItems().add("24");
        dayBox.getItems().add("26");
        dayBox.getItems().add("27");
        dayBox.getItems().add("28");
        dayBox.getItems().add("29");
        dayBox.getItems().add("30");
        dayBox.getItems().add("31");

        
        
        // Year comboBox items
        yearBox.getItems().add("2021");
        yearBox.getItems().add("2020");
        yearBox.getItems().add("2019");
        yearBox.getItems().add("2018");
        yearBox.getItems().add("2017");
        yearBox.getItems().add("2016");
        yearBox.getItems().add("2015");
        
    }  

    // Open Scoreboard view when list item is clicked
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
}
