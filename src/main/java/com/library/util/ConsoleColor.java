package com.library.util;

public class ConsoleColor {

    public static final String RESET  = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    private static final String MAGENTA = "\u001B[95m";
    private static final String CYAN = "\u001B[36m";
    
    
    public static String red(String txt)    { return RED    + txt + RESET; }
    public static String green(String txt)  { return GREEN  + txt + RESET; }
    public static String yellow(String txt) { return YELLOW + txt + RESET; }
    public static String blue(String txt)   { return BLUE   + txt + RESET; }
    public static String magenta(String txt) { return MAGENTA + txt + RESET; }
    public static String cyan(String txt)   { return CYAN + txt + RESET; }

    private ConsoleColor() { 
    }
}

