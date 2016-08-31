package com.daniloramirezcr;

import com.daniloramirezcr.mapgenerator.*;
import com.tips4java.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main  {

    private int width = 10; //This is the example width
    private int height = 10; //This is the example height
    private int tolerance = 5; //This is the example tolerance
    private boolean saveImage = false; // This indicates if we want to save the image.
    private boolean saveFile = false;
    private Map map = null;


    public void createMap(){
        this.map = new Map();
        Console.print("You are executing the version of the map generator: " + map.getVersion().toString());
        map.setHeight(height);
        map.setWidth(width);
        map.setTolerance(tolerance);
        map.startCalculation();
        map.enableMessages();
        map.setUpPossibleElements();
        map.generateMatrix();
        map.fillMap();
        map.printConsoleMap(this.saveFile); //The boolean is indicating if we want to print the map into a text and csv file.
    }

    public void createGraphic(){
        /**
         * The MapGraphic class is an special class that takes care of showing the map into a window. Its important to
         * pass the Map object to the class. If it is not passed, then it won't show anything.
         */
        MapGraphic mg = new MapGraphic();
        mg.setMap(map).showScreenMap();
        //Testing function
        /*if(this.saveImage){
            try{
                BufferedImage bi = ScreenImage.createImage(mg);
                ScreenImage.writeImage(bi,"test.jpg");
            }catch (java.awt.AWTException e){
                Console.print("The image couldn't be saved");
            }catch (Exception e){
                Console.print("Unknown error");
            }
        }*/
    }

    public Main() {
        this.createMap(); // Create the main Map
        this.createGraphic(); // Create the graphic presentation
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}

