package com.daniloramirezcr.mapgenerator;

import java.text.SimpleDateFormat; //Only for the simple date format
import java.util.*;
// The following two imports are for the array list functionality

/*
*   This is the main MAP class and object.
*   @author  Danilo Ramírez
*   @version  0.4
* */
public class Map {

    private int width = 20;
    private int height = 20;
    private int totalElements = 0;
    private String version = "0.4";
    private MapElement[][] mapContent;
    private MapElement[] possibleElements;
    private boolean sendMessagesToConsole = false;

    private List<MapElement>[] addedElements; // The list of those elements already added to the map (just for orden)

    private int total_added = 0; //Counter for the total elements added
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
     * This function will return true when the map is full.
     * @return
     */
    public boolean mapIsFull(){
        this.mes("Calculating if the map is filled");
        int expected_total = this.getWidth() * this.getHeight();
        int total_found = 0;
        for(int h = 0 ; h < this.getHeight() ; h++){
            for(int w=0 ; w < this.getWidth() ; w++){
                if( this.mapContent[w][h] != null ){
                    total_found++;
                }
            }
        }

        this.mes("Total elements found: " + Integer.toString(total_found));
        this.mes("Total elements expected: " + Integer.toString(expected_total));
        if( total_found >= expected_total ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This function set up the possible elements for this map. It will also set up the added lists to control the elements.
     */
    public void setUpPossibleElements(){
        this.possibleElements = MapElement.getPossibleElements();
        // We are creating an array of array list. With this I mean that we are creating an array of the number
        // of posible element, and for each array we are going to store all added elements per type
        this.addedElements = (ArrayList<MapElement>[])new ArrayList[ this.possibleElements.length ];
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
        while( !this.mapIsFull() ){
            this.setRandomSeed(); //TODO change this to execute until full
        }
        this.mes("Ending process");
    }

    /**
     * Function to start the calculation of time
     */
    public void startCalculation(){
        this.start = new Date();
    }
    /**
     * This function will calculate the time between the start of the class and this call and will try
     * to send the message to console
     */
    public void calculateTime(){
        this.end = new Date();
        this.start.getTime();
        long difference = this.end.getTime() - this.start.getTime(); //This is the time between dates in milliseconds
        this.mes( "The class MAP process took " + Long.toString(difference) + " milliseconds" );
    }

    /**
     * This function will print the map in console mode. It cannot use the same function as message because we dont want to to print time or all in the same line.
     */
    public void printConsoleMap(){
        this.mes("Printing the map. Please wait.");
        System.out.println("");//Print an empty space, just for order
        for(int h = 0 ; h < this.getHeight() ; h++){
            for(int w=0 ; w < this.getWidth() ; w++){
                if( this.mapContent[w][h] == null ){
                    System.out.print( " " + " " );
                }else{
                    System.out.print( this.mapContent[w][h].getFirstLetterOfType() + " " );
                }
            }
            System.out.println();
        }
        System.out.println("");//Print an empty space, just for order

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

        if( this.addedElements[ randomElement.location_type ] != null  && this.addedElements[ randomElement.location_type ].size() > 0 ){
            boolean added = false;
           /* try{
                added = this.extendSeed( (MapElement) randomElement.clone() );
            }catch(CloneNotSupportedException c){}*/
            if( !added ){
                try{
                    this.generateNewRandomSeed( (MapElement) randomElement.clone() );
                }catch(CloneNotSupportedException c){}
            }
        }else{
            try{
                this.generateNewRandomSeed( (MapElement) randomElement.clone() );
            }catch(CloneNotSupportedException c){}
        }
    }

    /**
     * This function will try to extend one seed at the map. If not, then it will return false so the map can generate a new seed
     * @param randomElement The element to extend
     * @return boolean The result of the process.
     */
    private boolean extendSeed(MapElement randomElement){
        //First we get a random element from the existing list.
        this.mes("Trying to extend a seed");
        Random rand = new Random();
        int random_number = rand.nextInt( this.addedElements[ randomElement.location_type ].size() );
        MapElement aux = this.addedElements[ randomElement.location_type ].get(random_number);
        //This is the location. 0 for top, 1 for right, 2 for bottom, 3 for left
        List<Integer> solution = new ArrayList<>();
        for ( int i = 0 ; i < 4 ; i++ ){
            solution.add(i);
        }
        Collections.shuffle(solution);

        boolean added = false; //This will help us to identify when it has been added.
        for( int i = 0 ; i < 4 ; i ++ ){ //Lets try to locate an space to add the new element
            this.mes("Trying location at number: " + Integer.toString(i));
            int aux_location = solution.get( i );
            try{
                switch (aux_location) {
                    case 0:
                        this.mes("Position TOP");
                        if(  aux.top == null && aux.getLocationW() > 0 && this.mapContent[ aux.getLocationW()-1 ][ aux.getLocationH() ] == null ) {
                            this.setMapElementAtPosition( aux.getLocationH(), aux.getLocationW() -1, randomElement );
                            added = true;
                            i = 4;
                        }

                        break;
                    case 1:
                        this.mes("Position RIGHT");
                        if(  aux.right == null && aux.getLocationH() < getHeight()-1 && this.mapContent[ aux.getLocationW() ][ aux.getLocationH() + 1 ] == null ) {
                            this.setMapElementAtPosition( aux.getLocationH() + 1 , aux.getLocationW() , randomElement );
                            added = true;
                            i = 4;
                        }
                        break;
                    case 2:
                        this.mes("Position BOTTOM");
                        if(  aux.bottom == null && aux.getLocationW() < this.getWidth()-1 && this.mapContent[ aux.getLocationW() +1 ][ aux.getLocationH()  ] == null ) {
                            this.setMapElementAtPosition( aux.getLocationH(), aux.getLocationW() +1, randomElement );
                            added = true;
                            i = 4;
                        }
                        added = true;
                        i = 4;
                        break;
                    case 3:
                        this.mes("Position LEFT");
                        if(  aux.left == null && aux.getLocationH() > 0 && this.mapContent[ aux.getLocationW() ][ aux.getLocationH()  -1 ] == null ) {
                            this.setMapElementAtPosition( aux.getLocationH() -1, aux.getLocationW(), randomElement );
                            added = true;
                            i = 4;
                        }

                        break;
                }
            }catch (Exception e){
                this.mes("Exception extending seed");
            }


        }

        return added; //We return true if it was added or false if not.
    }

    /**
     * This function will generate a new seed at any place of the map. This function find a location and send it to other function.
     * @param randomElement
     */
    private void generateNewRandomSeed(MapElement randomElement){
        this.mes("Searching for place to generate a random seed");

        boolean added = false;
        while(added == false){
            Random rand = new Random();
            int random_number_w = rand.nextInt(this.width);
            int random_number_h = rand.nextInt(this.height);
            //We are clonning the element, but somehow the clone method is returning an object method only.
            this.mes("We are going to try to write the random element to w=" + Integer.toString(random_number_w) + " and h=" + Integer.toString(random_number_h));
            if(this.mapContent[random_number_w][random_number_h] == null){
                    this.setMapElementAtPosition( random_number_w , random_number_h , randomElement );
                    added = true;
            }else{
                this.mes("Space occupped. Retrying");
            }
        }

    }


    /**
     * This function will set a map seed at a position on the map
     * @param w The width position
     * @param h The height position
     * @param element The element be added
     * @return The same element is returned
     */
    private MapElement setMapElementAtPosition(int w, int h, MapElement element){
        this.mes("Element added at: W = " + Integer.toString(w) + " H = " + Integer.toString(h) );
        this.mapContent[w][h] = element;
        element.setLocation( h , w );

        if(this.addedElements[ element.location_type ] == null){
            this.addedElements[ element.location_type ] = new ArrayList<MapElement>();
        }
        this.addedElements[ element.location_type ].add( element );
        this.total_added++; //We increase the counter of spaces filled
        return element;
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
        MapElement aux = this.possibleElements[ random_number ];
        aux.location_type = random_number;

        return aux;
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
