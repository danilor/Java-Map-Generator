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

    private int width = 20;
    private int height = 20;
    public static void main(String[] args) {
        Main m = new Main();
        m.execute();
    }

    public void execute(){
        // Creating the new map object from the class
        Map map = new Map();
        //Setting up the width and height. Even when the map has default values, its important to have them here.
        map.setWidth(this.width);
        map.setHeight(this.height);
        //Printing the welcome message
        Console.print("Welcome to the Random Map Generator");
        Console.print("You are executing the version of the map generator: " + map.getVersion().toString() );
        Console.printSpace();
        Console.print("Generating the map");
        map.generateMatrix();

    }
}
