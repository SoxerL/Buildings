/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class contains the presentation model for this Project
 */
package buildings;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class contains the presentation model of the building view application
 * it contains a regular apllication window layout and a connection to the
 * datamodel
 * 
 * @author Sacha
 * @version 0.1
 */
public class BuildingsPresentation extends Application {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            /*BuildingsData.openFile(primaryStage);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(primaryStage);
            BuildingsData.readFile(file.getPath);
            */
            System.out.println("Hello World!");
        });
        
        HBox root = new HBox();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
}
