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
     * This function will return the possible elements to use.
     *
     * @return MapElement[] List of elements
     */
    public static MapElement[] getPossibleElements(){
        MapElement[] possibleElements = new MapElement[4];
        possibleElements[0] = new MapElement();
        possibleElements[0].setType("forest");
        possibleElements[0].setBackgroundColor("green");
        possibleElements[0].setPorcent(30);
        possibleElements[1] = new MapElement();
        possibleElements[1].setType("dessert");
        possibleElements[1].setBackgroundColor("yellow");
        possibleElements[1].setPorcent(10);
        possibleElements[2] = new MapElement();
        possibleElements[2].setType("water");
        possibleElements[2].setBackgroundColor("lightblue");
        possibleElements[0].setPorcent(40);
        possibleElements[3] = new MapElement();
        possibleElements[3].setType("sabana");
        possibleElements[3].setBackgroundColor("lightgreen");
        possibleElements[0].setPorcent(20);
        return possibleElements;
    }
}
