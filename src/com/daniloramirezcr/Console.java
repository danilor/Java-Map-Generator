/*
*   This class has the only purpose of working as an intermediary to the console messages system.
*   @author  Danilo Ramírez
*   @version  0.2
* */
package com.daniloramirezcr;



/*
* This class will help other
* */
public class Console {

    // Colors for the terminal. TODO Test something with this colors. Taken from: http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static boolean print(String t){
        System.out.println(t);
        return true;
    }
    public static boolean printSpace(){
        System.out.println("");
        return true;
    }
}
