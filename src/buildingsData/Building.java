/*
 * OOP2 Project - Buildings view application
 * Author: Sacha Leemann
 * This class is part of the datamodel for this Project except the buildings class
 */
package buildingsData;

/**
 * This class is used to represent the biggest buildings in the World.
 * 
 * @author Sacha
 * @version 0.1
 *
 */
public class Building {
    
    protected int ID;
    protected int rank;
    protected String name;
    protected String city;
    protected String country;
    protected float heightM;
    protected float heightFT;
    protected short floors;
    protected short buildYear;
    protected String architect;
    protected String architecturalStyle;
    protected double cost;
    protected String material;
    protected float longitude;
    protected float latitude;
    protected String imageURL;
    
    public Building(int ID, String name, float heightM) {
        this.ID = ID;
        this.name = name;
        this.heightM = heightM;
    }

    public int getiD() {
        return ID;
    }

    public void setiD(int ID) {
        this.ID = ID;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getHeightM() {
        return heightM;
    }

    public void setHeightM(float heightM) {
        this.heightM = heightM;
    }

    public float getHeightFT() {
        return heightFT;
    }

    public void setHeightFT(float heightFT) {
        this.heightFT = heightFT;
    }

    public short getFloors() {
        return floors;
    }

    public void setFloors(short floors) {
        this.floors = floors;
    }

    public short getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(short buildYear) {
        this.buildYear = buildYear;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public String getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }    
}
