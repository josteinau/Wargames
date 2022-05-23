package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MainController {
    @FXML


    public void fight(ActionEvent e){
        System.out.println("fighting");
    }
    public void resetFight(ActionEvent e){
        System.out.println("Resetting fight");
    }
    public void newFight(ActionEvent e){
        System.out.println("New fight inc");
    }
    public void addToArmy(ActionEvent e){
        System.out.println("Added to army");
    }
}
