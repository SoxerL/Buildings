/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class contains the complete datamodel for this Project except the buildings class
 */
package buildings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
            // Do Something
        } catch (FileFormatException f) {
            // Do Something
        } catch (IOException io) {
            // Do Something
        }
    }
    
    public void openFile() {
        // gets activated on pressing openfile, should promp a window where you can enter a file
        // gets the filePath and gives it to the readFile method
        readFile(filePath);
    
    }
    
    public void saveFile() {
        // save the current open file (apply changes at this point)
        
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
