/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class is part of the presentation model for this Project
 * and contains Application start
 */
package buildingsUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sacha
 */
public class BuildingsMain extends Application{
     public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorRoot = new AnchorPane();
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(200);
        
        anchorRoot.setPrefWidth(600);
        anchorRoot.setPrefHeight(400);
        
               
        VBox root = BuildingsPresentation.root();
        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        AnchorPane.setTopAnchor(root,1.0);
        AnchorPane.setLeftAnchor(root,1.0);
        AnchorPane.setBottomAnchor(root,1.0);
        AnchorPane.setRightAnchor(root, 1.0);
        anchorRoot.getChildren().add(root);
        
        Scene scene = new Scene(anchorRoot, 600, 400);
        
        primaryStage.setTitle("Buildings");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(BuildingsPresentation.class.getResource("../ressources/BuildingsWithStyle.css").toExternalForm());
        primaryStage.show();
    }
}
