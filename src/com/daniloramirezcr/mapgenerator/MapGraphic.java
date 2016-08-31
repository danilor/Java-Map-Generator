package com.daniloramirezcr.mapgenerator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Danilo on 27/8/2016.
 * This class will support the MAP class and create MAP Graphic interface.
 */
public class MapGraphic extends JFrame {
    /**
     * Constructor
     */

    private Map map;

    /**
     * The constructor of the class.
     */
    public void MapGraphic(){

    }

    /**
     * This function sets the map content
     * @param m The Map Element
     * @return MapGraphic The MapGraphic
     */
    public MapGraphic setMap(Map m){
        this.map = m;
        return this;
    }

    /**
     * Function that shows the map to a Window
     */
    public void showScreenMap(){
        if(this.map != null){
            this.setLayout(new GridLayout(this.map.getHeight(), map.getWidth()));
            for (int h = 0; h < this.map.getHeight(); h++) {
                for (int w = 0; w < this.map.getWidth(); w++) {
                    JPanel area = new JPanel();
                    if (this.map.getMapContent()[w][h] != null) {
                        area.setBackground( this.map.getMapContent()[w][h].getBackColor() );
                    }
                    this.add(area); // This puts all 100 numbers in place
                }
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

    }



}
