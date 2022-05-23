
import Battle.Army;
import Battle.Battle;
import Battle.Terrain;
import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import units.*;
import util.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main  { // extends Application


    public static void main(String[] args) throws IOException, InterruptedException {

        FileHandler fh = new FileHandler();
        UnitFactory uf = new UnitFactory();
        List<Unit> hums = new ArrayList<>();
        List<Unit> orcs = new ArrayList<>();
        File orcFile = new File("Orcs.csv");
        File humanFile = new File("Humans.csv");

        Army testOrc = new Army("Horde",orcs);
        Army testHums = new Army("Humans",hums);

        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new CavalryUnit("Per", 25));
        hums.add(new RangedUnit("Knut", 25));

        orcs.add(new CommanderUnit("Thrall", 150));
        orcs.add(new InfantryUnit("Grom", 40));
        orcs.add(new CavalryUnit("Khal", 25));
        orcs.add(new RangedUnit("Gork", 25));

        Scanner sc = new Scanner(System.in);
        System.out.println("Add units to orcs\nChoose one of following types:\nCommander\nRanger\nCavalry\nInfantry\n");
        String choseUnit = sc.next();
        System.out.println("Choose number of units");
        int chooseNumUnits = sc.nextInt();
        System.out.println("Choose name of unit");
        String nameUnit = sc.next();
        System.out.println("Choose health of unit");
        int chooseHealth = sc.nextInt();

        switch(choseUnit){
            case "Commander":
                orcs.addAll(uf.createManyUnits(chooseNumUnits,UnitType.COMMANDER_UNIT,nameUnit,chooseHealth));
                break;
            case "Ranger":
                orcs.addAll(uf.createManyUnits(chooseNumUnits,UnitType.RANGED_UNIT,nameUnit,chooseHealth));
                break;
            case "Cavalry":
                orcs.addAll(uf.createManyUnits(chooseNumUnits,UnitType.CAVALRY_UNIT,nameUnit,chooseHealth));
                break;
            case "Infantry":
                orcs.addAll(uf.createManyUnits(chooseNumUnits,UnitType.INFANTRY_UNIT,nameUnit,chooseHealth));
                break;
        }
        Battle bat = new Battle(testOrc,testHums, Terrain.FOREST);
        bat.simulate();
        fh.writeUnits(orcs,orcFile);
        fh.writeUnits(hums,humanFile);

       // Application.launch(args);
    }

    /*
   // @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));



            // Scene sceneName = new Scene(root, Color.DARKGRAY);
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);

            Image icon = new Image("file:GUI/OrcWar.PNG");
            primaryStage.getIcons().add(icon);
            primaryStage.setWidth(1280);
            primaryStage.setHeight(900);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Wargames");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }

    } */
}
