package com.daniloramirezcr.mapgenerator;

/*
*   This is each element of the map
*   @author  Danilo Ramírez
*   @version  0.2
* */
public class MapElement {
    private String type = "empty";
    private String backgroundColor = "white";
    public void MapElement(){

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
     * This function will return the possible elements to use.
     *
     * @return MapElement[] List of elements
     */
    public static MapElement[] getPossibleElements(){
        MapElement[] possibleElements = {};
        possibleElements[0] = new MapElement();
        possibleElements[0].setType("forest");
        possibleElements[0].setBackgroundColor("green");
        possibleElements[1] = new MapElement();
        possibleElements[1].setType("dessert");
        possibleElements[1].setBackgroundColor("yellow");
        possibleElements[2] = new MapElement();
        possibleElements[2].setType("water");
        possibleElements[2].setBackgroundColor("lightblue");
        possibleElements[3] = new MapElement();
        possibleElements[3].setType("sabana");
        possibleElements[3].setBackgroundColor("lightgreen");
        return possibleElements;
    }
}
