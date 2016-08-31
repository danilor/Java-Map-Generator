package com.daniloramirezcr;

import com.daniloramirezcr.mapgenerator.*;
import javax.swing.*;
import java.awt.*;

public class Main  {

    private int width = 100; //This is the example width
    private int height = 100; //This is the example height
    private int tolerance = 5; //This is the example tolerance

    public Main() {
        Map map = new Map();
        Console.print("You are executing the version of the map generator: " + map.getVersion().toString());
        map.setHeight(height);
        map.setWidth(width);
        map.setTolerance(tolerance);
        map.startCalculation();
        map.enableMessages();
        map.setUpPossibleElements();
        map.generateMatrix();
        map.fillMap();
        map.printConsoleMap(false); //The boolean is indicating if we want to print the map into a text and csv file.

        /**
         * The MapGraphic class is an special class that takes care of showing the map into a window. Its important to
         * pass the Map object to the class. If it is not passed, then it won't show anything.
         */
        MapGraphic mg = new MapGraphic();
        mg.setMap(map).showScreenMap();

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}

