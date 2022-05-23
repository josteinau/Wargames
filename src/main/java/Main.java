import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import GUI.*;


import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

            /**
             * SCENE HERE
             */

            // Scene sceneName = new Scene(root, Color.DARKGRAY);
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);
            /**
             * STAGE HERE
             */
            Image icon = new Image("file:GUI/OrcWar.PNG");
            primaryStage.getIcons().add(icon);
            primaryStage.setWidth(1280);
            primaryStage.setHeight(760);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Wargames");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
