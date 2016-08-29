package com.daniloramirezcr.mapgenerator;

/*
*   This is each element of the map
*   @author  Danilo Ramírez
*   @version  0.2
* */
public class MapElement implements Cloneable{
    private String type = "empty";
    private String backgroundColor = "white";
    private int porcent = 100;
    // The following two variables are optional and the idea is to store the location of the element
    private int location_w;
    private int location_h;
    public int location_type = 0; //This variable should organize the type of the element in the map. I am making this public because I want to access this variable and modify it as easy as I can.

    // The following 4 variables were made to control the position of the elements around this one. This should be public for easy access.
    public MapElement top, bottom, left, right;


    public void MapElement(){

    }

    /**
     * This function will set the location of this element. This is optional
     * @param h
     * @param w
     */
    public void setLocation(int h, int w){
        this.location_h = h;
        this.location_w = w;
    }

    /**
     * Get the location x
     * @return int Location X
     */
    public int getLocationW(){
        return this.location_w;
    }

    /**
     * Get the Location Y
     * @return int Location Y
     */
    public int getLocationH(){
        return this.location_h;
    }

    /**
     *  Set the type
     * @param  t The type of the element
     * @return Nothing
     */
    public void setType(String t){    this.type = t; }
    /**
     *  Get the type
     * @return String The type of the map
     */
    public String getType(){  return this.type;  }

    /**
     *  Set the background color
     * @param  c The background color of the element
     * @return Nothing
     */
    public void setBackgroundColor(String c){    this.backgroundColor = c; }
    /**
     *  Get the background color
     * @return String The type of the map
     */
    public String getBackgroundColor(){  return this.backgroundColor;  }


    /**
     * This will get the porcent posibilities
     * @return int porcent
     */
    public int getPorcent(){
        return this.porcent;
    }

    /**
     * This will set the porcent
     * @param p porcent
     */
    public void setPorcent(int p){
        this.porcent = p;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * This will return the first letter of the type element. It is just to show in the map.
     * @return String the first letter of the element type
     */
    public String getFirstLetterOfType(){
            return this.getType().substring(0,1);
    }

    /**
     * This function will return the possible elements to use.
     *
     * @return MapElement[] List of elements
     */
    public static MapElement[] getPossibleElements(){
        MapElement[] possibleElements = new MapElement[5];
        possibleElements[0] = new MapElement();
        possibleElements[0].setType("Forest");
        possibleElements[0].setBackgroundColor("green");
        possibleElements[0].setPorcent(40);
        possibleElements[1] = new MapElement();
        possibleElements[1].setType("Dessert");
        possibleElements[1].setBackgroundColor("yellow");
        possibleElements[1].setPorcent(10);
        possibleElements[2] = new MapElement();
        possibleElements[2].setType("Water");
        possibleElements[2].setBackgroundColor("lightblue");
        possibleElements[2].setPorcent(10);
        possibleElements[3] = new MapElement();
        possibleElements[3].setType("Sabana");
        possibleElements[3].setBackgroundColor("lightgreen");
        possibleElements[3].setPorcent(20);
        possibleElements[4] = new MapElement();
        possibleElements[4].setType("Mountain");
        possibleElements[4].setBackgroundColor("gray");
        possibleElements[4].setPorcent(20);
        return possibleElements;
    }


}
