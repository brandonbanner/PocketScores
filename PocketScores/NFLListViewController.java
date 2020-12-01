package PocketScores;
import static PocketScores.FullListItemTemplateController.fullListItem;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.ScrollBar;
import java.lang.Object;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class NFLListViewController implements Initializable, ActionListener {

    // Items
    @FXML
    private Pane listBase;
    
    @FXML
    private JFXHamburger navButton;
    
    @FXML
    private JFXDrawer menuDrawer;

    @FXML
    private ScrollPane backdrop;
    
    @FXML
    private DatePicker datePicker;
    
    static int gameNum;
    
    //String txt = "Text";
    NFLModel nflModel = new NFLModel (StartupViewController.date);
    
    Node fullListItem;

    //NFLListViewController listItemList = new NFLListViewController ();

    
   // Menu Sliding Drawer
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        backdrop.setContent(listBase);
        backdrop.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        backdrop.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        

        genListItem(nflModel.getNumGames());
        
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
        
    }  
    
    // Generate HBox list items based upon number of games
    public void genListItem(int numGames){
        for(int i = 0, x = 42, y = 84, g = 1 ; i < numGames && g <= numGames; i++, y += 84, g++){
          genFullListItem(x, y, g);
        }
            
    }

    // Open Scoreboard view when list item is clicked
    private void handlelistItem(MouseEvent event) {

        try{
            
        Node source = (Node) event.getSource();
        NFLListViewController.gameNum = Integer.parseInt(source.getId());
       // NFLListViewController.gameNum = Integer.parseInt(event.gets);
        
        
           FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("/PocketScores/NFLScoreBoard.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PocketScores.window.setTitle("PocketScores: Current NFL Game");
                PocketScores.window.setScene(new Scene(root1));
                PocketScores.window.show();

                
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    
    private void genFullListItem(int x, int y, int g) {
        FXMLLoader loader = new FXMLLoader();
        
        try{
            Node fli = loader.load(getClass().getResource("FullListItemTemplate.fxml").openStream());
            listBase.getChildren().add(fli);
            fli.setId("" + g);
            fli.setLayoutX(x);
            fli.setLayoutY(y);
            fli.toBack();
            fullListItem = fli;
            
            // Get Controller
            FullListItemTemplateController homeTeamName = (FullListItemTemplateController) loader.getController();
            homeTeamName.setHomeTeamName(nflModel.getHomeTeam(g));
            //homeTeamName.setHomeTeamName(txt);
            
            FullListItemTemplateController visitorTeamName = (FullListItemTemplateController) loader.getController();
            visitorTeamName.setAwayTeamName(nflModel.getAwayTeam(g));
            //visitorTeamName.setAwayTeamName(txt);
            
            FullListItemTemplateController gameTime = (FullListItemTemplateController) loader.getController();
            gameTime.setGameTime(nflModel.getStartTime(g));
            //gameTime.setGameTime(txt);
            
            FullListItemTemplateController gameDate = (FullListItemTemplateController) loader.getController();
            gameDate.setGameDate(StartupViewController.date);

        } catch (IOException ex){
            ex.printStackTrace();
    }
}

    @FXML
    private void handleDate(ActionEvent event) {
        
        listBase.getChildren().remove(fullListItem);
        LocalDate thedate = datePicker.getValue();
        StartupViewController.date = String.valueOf(thedate);
       nflModel = new NFLModel (StartupViewController.date);
       genListItem(nflModel.getNumGames());
    }
    public String getDate (){
        return StartupViewController.date;
    }
    

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
       Node source = (Node) e.getSource();
        NFLListViewController.gameNum = Integer.parseInt(source.getId());
    }
}