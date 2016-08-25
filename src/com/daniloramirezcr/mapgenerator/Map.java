package com.daniloramirezcr.mapgenerator;

import java.text.SimpleDateFormat; //Only for the simple date format
import java.util.Date; //The date
import java.util.Random;
/*
*   This is the main MAP class and object.
*   @author  Danilo Ramírez
*   @version  0.2
* */
public class Map {

    private int width = 20;
    private int height = 20;
    private int totalElements = 0;
    private String version = "0.2";
    private MapElement[][] mapContent;
    private MapElement[] possibleElements;
    private boolean sendMessagesToConsole = false;
    // The following variables is to calculate the time between two dates.
    private Date start;
    private Date end;

    /**
    * Map Constructor.
    */
    public void Map(){
        this.start = new Date();
        this.setUpPossibleElements();
    }

    /**
     *  Map Constructor with parameters
     *
     * @param  w The width of the map
     * @param  h The height of the map
     * @return Nothing
     */
    public void Map(int w, int h){
        this.start = new Date();
        this.width = w;
        this.height = h;
        this.setUpPossibleElements();
    }
    /**
     * This function set up the possible elements for this map
     */

    public void setUpPossibleElements(){
        this.possibleElements = MapElement.getPossibleElements();
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
    public void setWidth(int w){  this.mes("Setting up the width to: " + Integer.toString(w) );   this.width = w; }
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
    public void setHeight(int h){  this.mes("Setting up the height to: " + Integer.toString(h) );  this.height = h; }
    /**
     *  Get the height
     * @return int The height of the map
     */
    public int getHeight(){  return this.height;  }

    /**
     * This function will set up the messages functionality of this class
     */
    public void setMessagesBool(boolean b){
        this.sendMessagesToConsole = b;
    }

    /**
     * This function will automatically set the messages to true
     */
    public void enableMessages(){
        this.setMessagesBool(true);
        this.mes("Class messages enabled. If you want to disable this feature please call the method setMessagesBool with a false parameter.");
    }

    /**
     *  Get the messages boolean
     * @return bool The messages option
     */
    public boolean getMessagesBool(){  return this.sendMessagesToConsole;  }


    /**
     * Map Generator. It will generate the main Matrix of the map.
     */
    public void generateMatrix(){
        this.mes("Generating the matrix width w=" + Integer.toString(this.width) + " and h=" + Integer.toString(this.height));
        this.mapContent = new MapElement[this.width][this.height];
    }

    /**
     * This function will fill the map with the information.
     */
    public void fillMap(){
        this.totalElements = this.getHeight() * this.getWidth(); //We get the total elements we are going to write in the map
        this.mes("Filling map of a total of " + Integer.toString(this.totalElements) + " elements");

        this.setRandomSeed(); //TODO change this to execute until full
    }

    /**
     * This function will calculate the time between the start of the class and this call and will try
     * to send the message to console
     */
    public void calculateTime(){ //TODO see why the start is not being stored
        //this.end = new Date();
        //this.start.getTime();
        //long difference = this.end.getTime() - this.start.getTime(); //This is the time between dates in milliseconds
        //this.mes( "The class MAP process took " + Long.toString(difference) + " seconds" );
    }

    /////////////////////////////////////////////////////////////////////
    //          PRIVATE METHODS
    /////////////////////////////////////////////////////////////////////

    /**
     * This function will set a random seed at the map. If the space is taken then it will try again.
     */
    private void setRandomSeed(){
        this.mes("Setting up the random seed in the map");
        MapElement randomElement = this.getRandomElement();
        Random rand = new Random();
        int random_number_w = rand.nextInt(this.width);
        int random_number_h = rand.nextInt(this.height);
        this.mes("We are going to try to write the random element to w=" + Integer.toString(random_number_w) + " and h=" + Integer.toString(random_number_h));

        boolean added = false;
        while(added == false){
            //We are clonning the element, but somehow the clone method is returning an object method only.
            try{
                this.mapContent[random_number_w][random_number_h] = (MapElement) randomElement.clone();
            }catch(CloneNotSupportedException c){}

            added = true;
        }
    }

    /**
     * This function will return a random element from the posible list.
     * @return The random map element
     */
    private MapElement getRandomElement(){
        this.mes("Getting a random element");
        Random rand = new Random();
        int random_number = rand.nextInt(this.possibleElements.length);
        this.mes("We got a random number " + Integer.toString(random_number) + " of " + Integer.toString(this.possibleElements.length));
        this.mes("The Map element is from type: " + this.possibleElements[random_number].getType());
        return this.possibleElements[random_number];
    }

    /**
     * This method will send a message to console. We are not using the class at com.daniloramirezcr.Console because we want
     * this method to be autosufficient.
     * @param t The message we want to send.
     */
    private void mes(String t){
        if(this.sendMessagesToConsole){
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
            Date now = new Date();
            String strDate = sdfDate.format(now);
            System.out.println("MAP ["+ strDate + "]: " + t);
        }
    }



}
