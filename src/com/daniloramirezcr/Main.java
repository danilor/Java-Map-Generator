package com.daniloramirezcr;
/*
*   This is the main class.
*   @author  Danilo Ramírez
*   @version  0.2
* */
import com.daniloramirezcr.mapgenerator.*;
/*
* Main class. Executing the application
* */
public class Main {

    private int width = 40; //This is the example width
    private int height = 30; //This is the example height
    private int tolerance = 5; //This is the example tolerance
    private boolean printToFile = false; // This indicates if we want to print the map into a file
    public static void main(String[] args) {
        Main m = new Main();
        m.execute();
    }

    public void execute(){
        //Printing the welcome message
        Console.print("|=====================================|");
        Console.print("| Welcome to the Random Map Generator |");
        Console.print("|=====================================|");
        // Creating the new map object from the class
        Map map = new Map();
        Console.print("You are executing the version of the map generator: " + map.getVersion().toString() );
        map.startCalculation();
        map.enableMessages();
        map.setUpPossibleElements();
        //Setting up the width and height. Even when the map has default values, its important to have them here.
        map.setWidth(this.width);
        map.setHeight(this.height);
        map.setTolerance(this.tolerance);
        Console.printSpace();
        Console.print("Generating the map");
        map.generateMatrix();
        map.fillMap();
        map.printConsoleMap( this.printToFile ); // This will print the map in console mode
        map.calculateTime(); // This is the very last function to be called

    }
}
