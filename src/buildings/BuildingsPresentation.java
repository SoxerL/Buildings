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
        VBox root = new VBox();
        //root.getChildren().add(toolBar(), splitRoot());
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Buildings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public ToolBar toolBar() {
        // add Buttons to Toolbar for
        // Open File, Save, add Entry, delete entry, undoi, redo, (mapView), searchBox (far right side)
        ToolBar toolBar = new ToolBar();
        
        return toolBar;
    }
    
    public SplitPane splitRoot() {
        SplitPane splitRoot = new SplitPane();
        splitRoot.setOrientation(Orientation.HORIZONTAL);
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
    /*
    * General structur: VBOX containing Toolbar and Splitpane1 (horizontal)
    * Splitpane1 containing Listview (left) and VBOX (right)
    * VBox containing Splitpane2 (horizontal)(top) and Detailview bottom
    * Splitpane2 containing Main attributes (left) and ImageView(Right)
    */