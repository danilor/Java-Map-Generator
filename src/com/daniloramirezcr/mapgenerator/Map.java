package com.daniloramirezcr.mapgenerator;
/*
*   This is the main MAP class and object.
*   @author  Danilo Ramírez
*   @version  0.2
* */
public class Map {

    private int width = 20;
    private int height = 20;
    private String version = "0.2";
    private MapElement[][] mapContent;

    /**
    * Map Constructor.
    */
    public void Map(){

    }

    /**
     *  Map Constructor with parameters
     *
     * @param  w The width of the map
     * @param  h The height of the map
     * @return Nothing
     */
    public void Map(int w, int h){
        this.width = w;
        this.height = h;
    }

    /**
     *  Get the height
     * @return int The height of the map
     */
    public String getVersion(){  return this.version;  }


    /**
     *  Set the width
     * @param  w The width of the map
     * @return Nothing
     */
    public void setWidth(int w){    this.width = w; }
    /**
     *  Get the width
     * @return int The width of the map
     */
    public int getWidth(){  return this.width;  }

    /**
     *  Set the height
     * @param  h The height of the map
     * @return Nothing
     */
    public void setHeight(int h){    this.height = h; }
    /**
     *  Get the height
     * @return int The height of the map
     */
    public int getHeight(){  return this.height;  }

    /**
     * Map Generator. It will generate the main Matrix of the map.
     */
    public void generateMatrix(){
        this.mapContent = new MapElement[this.width][this.height];
    }



}
