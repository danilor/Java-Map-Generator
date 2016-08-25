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
}
