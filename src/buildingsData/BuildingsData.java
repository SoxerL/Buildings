/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class is part of the datamodel for this Project except the buildings class
 */
package buildingsData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class handles the data part of a buildings view application
 * its contains methods to do regular CRUDE operations aswell as reading files
 * and filter the view.
 * 
 * @author Sacha
 * @version 0.1
 */
public class BuildingsData {
    
    ObservableList<Building> observBuildings = FXCollections.observableArrayList();
    Alert alert;
    
    public void readFile(String filePath) {
        // Read in a new ascii file, throws exception if file has wrong formatting (ie takes int, gets string)
        // gets filename from open Method
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            String[] lineInput = line.split(",");
        
            if(lineInput[0].equals("ID") && lineInput[2].equals("BUILDING")) {
                while((line = br.readLine()) != null) {
                    lineInput = line.split(",");
                    // Construct a building object with the arguments ID, name and heightM
                    Building building = new Building(Integer.parseInt(lineInput[0]), lineInput[2], Float.valueOf(lineInput[5]));
                    building.setRank(Integer.parseInt(lineInput[1]));
                    building.setCity(lineInput[3]);
                    building.setCountry(lineInput[4]);
                    building.setHeightFT(Float.parseFloat(lineInput[6]));
                    building.setFloors(Short.parseShort(lineInput[7]));
                    building.setBuildYear(Short.parseShort(lineInput[8]));
                    building.setArchitect(lineInput[9]);
                    building.setArchitecturalStyle(lineInput[10]);
                    building.setCost(Double.parseDouble(lineInput[11]));
                    building.setMaterial(lineInput[12]);
                    building.setLongitude(Float.parseFloat(lineInput[13]));
                    building.setLatitude(Float.parseFloat(lineInput[14]));
                    building.setImageURL(lineInput[15]);
                    // Building needs to be added to the observableList
                    observBuildings.add(building);
                }
            } else {
               throw new FileFormatException(filePath);
            }
        } catch (FileNotFoundException f) {
            alert.setTitle("FileNotFoundException");
            alert.setContentText("Could not find file: " + filePath);
            alert.showAndWait();
        } catch (FileFormatException f) {
            alert.setTitle("FileFormatException");
            alert.setContentText(filePath + " has the wrong Format\n"
                                 + "Please chose a file with the following format:\n"
                                 + "ID;RANK;BUILDING;CITY;COUNTRY;HEIGHT_M;HEIGHT_FT;"
                                 + "FLOORS;BUILD;ARCHITECT;ARCHITECTUTAL_STYLE;COST;"
                                 + "MATERIAL;LONGITUDE;LATITUDE;IMAGE_URL");
            
            alert.showAndWait();
        } catch (IOException io) {
            alert.setTitle("IOException");
            alert.setContentText("The exception stacktrace was:");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            io.printStackTrace(pw);
            String stackTrace = sw.toString();
            TextArea textArea = new TextArea(stackTrace);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(textArea, 0, 1);

            // Set expandable Exception into the dialog pane.
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
        }
    }
    
    public void openFile(Stage primaryStage) {
        // gets activated on pressing openfile, should promp a window where you can enter a file
        // gets the filePath and gives it to the readFile method
        //readFile(filePath);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(primaryStage);
        readFile(file.getPath());
    }
    
    public void saveFile(Stage primaryStage) {
        // save the current open file (apply changes at this point)
        FileChooser fileChooser = new FileChooser();
  
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
              
        //Show save file dialog
        File file = fileChooser.showSaveDialog(primaryStage);
              
        if(file != null){
            try {
                FileWriter fileWriter = new FileWriter(file);
                for(int index = 0; index < observBuildings.size(); index++) {
                    StringBuilder buildLine = new StringBuilder();
                    Building b = observBuildings.get(index);

                    buildLine.append(b.getiD()).append(";");
                    buildLine.append(b.getRank()).append(";");
                    buildLine.append(b.getName()).append(";");
                    buildLine.append(b.getCity()).append(";");
                    buildLine.append(b.getCountry()).append(";");
                    buildLine.append(b.getHeightM()).append(";");
                    buildLine.append(b.getHeightFT()).append(";");
                    buildLine.append(b.getFloors()).append(";");
                    buildLine.append(b.getBuildYear()).append(";");
                    buildLine.append(b.getArchitect()).append(";");
                    buildLine.append(b.getArchitecturalStyle()).append(";");
                    buildLine.append(b.getCost()).append(";");
                    buildLine.append(b.getMaterial()).append(";");
                    buildLine.append(b.getLongitude()).append(";");
                    buildLine.append(b.getLatitude()).append(";");
                    buildLine.append(b.getImageURL());
                    
                    fileWriter.write(buildLine.toString());
                    if(index < observBuildings.size() -1) {
                        fileWriter.write(System.lineSeparator());
                    }   
                }
                fileWriter.close();
            } catch (IOException io) {        
                // alert popup
            }
        }
    }
    
    public void newEntry() {
        // Create a new empty entry and opens it in detail view, do not make any changes to the file
    }
    
    public void editCurrentEntry() {
        // Edit the current displayed Entry, only change the GUI view, do not make any changes to the file
        // changes to the file occur when calling saveFile()
        
    }
    
    public void deleteCurrentEntry() {
        // Delete the current entry from the view, do not make any changes to the file
    }
    
    public void openEditor() {
        // As soon as we change to edit any entry a new window opens with an editor and an apply button
        
    }
    
    public void undo() {
        // starts when undo button is clicked, per click undos the last change
    }
    
    public void redo() {
        // starts when redo button is clicked, per click redos the last undone change 
    }
    
    public void search() {
        // Is the logic behind the search field, searches the list for the searched terms, and calls filterview()
    }
    
    public void filterView() {
        // filters the displayed list with the given attributes
    }    
    
    /*
    * This class defines a FileFormatException that should be thrown
    * if the given File doesnt have the specified Format as used in
    * Building class
    * @author Sacha
    * @version 0.1
    */
    private static class FileFormatException extends Exception {

        public FileFormatException(String filePath) {
        }
    }
}
