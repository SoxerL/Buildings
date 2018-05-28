/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class is part of the presentation model for this Project
 */
package buildingsUI;

import buildingsData.Building;
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
import javafx.scene.layout.AnchorPane;
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
public class BuildingsPresentation {
     
    // Injectable oder Objekt kreiren
        
     /**
     * @param args the command line arguments
     */
      
    
    public VBox root() {
        VBox root = new VBox(toolBar(), rootBottomAnchor());
        return root;
    }
    
    
    
    public AnchorPane rootBottomAnchor() {
        AnchorPane anchorRootBottom = new AnchorPane();
        SplitPane splitRootBottom = splitRoot();
        
        AnchorPane.setTopAnchor(splitRootBottom,0.0);
        AnchorPane.setLeftAnchor(splitRootBottom,0.0);
        AnchorPane.setBottomAnchor(splitRootBottom,0.0);
        AnchorPane.setRightAnchor(splitRootBottom, 0.0);
        anchorRootBottom.getChildren().add(splitRootBottom);
        
        splitRootBottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        return anchorRootBottom;
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
        SplitPane splitRoot = new SplitPane(anchorRootLeft(), anchorRootRight());
        splitRoot.setOrientation(Orientation.HORIZONTAL);
        splitRoot.setDividerPositions(0.3);
        return splitRoot;
    }
    
    public AnchorPane anchorRootLeft() {
        AnchorPane anchorRootLeft = new AnchorPane();
        ListView<Building> leftView = listView();
        
        AnchorPane.setTopAnchor(leftView,0.0);
        AnchorPane.setLeftAnchor(leftView,0.0);
        AnchorPane.setBottomAnchor(leftView,0.0);
        AnchorPane.setRightAnchor(leftView, 0.0);
        anchorRootLeft.getChildren().add(leftView);
        
        return anchorRootLeft;
    }
    
    public AnchorPane anchorRootRight() {
        AnchorPane anchorRootRight = new AnchorPane();
        VBox detailBox = detailBox();
        
        AnchorPane.setTopAnchor(detailBox,0.0);
        AnchorPane.setLeftAnchor(detailBox,0.0);
        AnchorPane.setBottomAnchor(detailBox,0.0);
        AnchorPane.setRightAnchor(detailBox, 0.0);
        anchorRootRight.getChildren().add(detailBox);
        
        return anchorRootRight;  
    }
    
    public ListView<Building> listView() {
        ListView<Building> leftView = new ListView<>();
        //leftView.itemsProperty().setValue(BuildingsData.observBuildings);
        return leftView;
    }
    
    public VBox detailBox() {
        VBox detailBox = new VBox(splitDetailBoxTop(),detailViewBottom());
        
        return detailBox;
    }
    
    public AnchorPane anchorDetailBoxTopLeft() {
        AnchorPane anchorDetailBoxTopLeft = new AnchorPane();
        
        Button btn = new Button();
        btn.setText("button");
        anchorDetailBoxTopLeft.getChildren().add(btn);
        
        return anchorDetailBoxTopLeft;
    }
    
    public AnchorPane anchorDetailBoxTopRight() {
        AnchorPane anchorDetailBoxTopRight = new AnchorPane();
        
        Button btn = new Button();
        btn.setText("button");
        anchorDetailBoxTopRight.getChildren().add(btn);
        
        return anchorDetailBoxTopRight;
    }
    
    
    public SplitPane splitDetailBoxTop() {
        SplitPane splitDetailBoxTop = new SplitPane(anchorDetailBoxTopLeft(), anchorDetailBoxTopRight());
        splitDetailBoxTop.setOrientation(Orientation.HORIZONTAL);
        splitDetailBoxTop.setPrefWidth(200);
        splitDetailBoxTop.setPrefHeight(160);
        splitDetailBoxTop.setDividerPositions(0.65);
        
        return splitDetailBoxTop;
    }
    
    public VBox detailViewBottom() {
        // Should display certain attributes in separated fields at the bottom of the right side VBOX
        return new VBox();
    }
}