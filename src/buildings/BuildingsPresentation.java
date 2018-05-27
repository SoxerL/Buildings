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
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        VBox root = new VBox(toolBar(), splitRoot());
        root.setPrefWidth(600);
        root.setPrefHeight(400);
        
        Scene scene = new Scene(root, 400, 600);
        
        primaryStage.setTitle("Buildings");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(BuildingsPresentation.class.getResource("/ressources/BuildingsWithStyle.css").toExternalForm());
        primaryStage.show();
    }
 
    public ToolBar toolBar() {
        // add Buttons to Toolbar for
        // Open File, Save, add Entry, delete entry, undo, redo, (mapView), searchBox (far right side)
        ToolBar toolBar = new ToolBar();
        Button openFile = new Button("Open File");
        toolBar.getItems().add(openFile);
        
        Button saveFile = new Button("Save File");
        toolBar.getItems().add(saveFile);
        
        Button addEntry = new Button("Add Entry");
        toolBar.getItems().add(addEntry);
        
        Button deleteEntry = new Button("Delete Entry");
        toolBar.getItems().add(deleteEntry);
        
        Button undo = new Button("Undo");
        toolBar.getItems().add(undo);
        
        Button redo = new Button("Redo");
        toolBar.getItems().add(redo);
        
        Button searchBox = new Button("Search Box");
        toolBar.getItems().add(searchBox);
        return toolBar;
    }
    
    public SplitPane splitRoot() {
        SplitPane splitRoot = new SplitPane();
        splitRoot.setOrientation(Orientation.HORIZONTAL);
        splitRoot.setDividerPositions(0.3);
        return splitRoot;
    }
    
    public ListView listView() {
        ListView leftView = new ListView();
        return leftView;
    }
    
    public VBox detailBox() {
        VBox detailBox = new VBox();
        return detailBox;
    }
    
    public SplitPane splitDetailBoxTop() {
        SplitPane splitDetailBoxTop = new SplitPane();
        splitDetailBoxTop.setOrientation(Orientation.HORIZONTAL);
        return splitDetailBoxTop;
    }
    
    public void detailViewBottom() {
        // Should display certain attributes in separated fields at the bottom of the right side VBOX
    }
}