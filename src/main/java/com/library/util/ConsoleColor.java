package com.library.util;

public class ConsoleColor {
    
    // Colores básicos
    public static final String RESET   = "\u001B[0m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String WHITE   = "\u001B[37m";
    
    // Colores brillantes
    public static final String BRIGHT_BLACK   = "\u001B[90m";
    public static final String BRIGHT_RED     = "\u001B[91m";
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String BRIGHT_YELLOW  = "\u001B[93m";
    public static final String BRIGHT_BLUE    = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN    = "\u001B[96m";
    public static final String BRIGHT_WHITE   = "\u001B[97m";
    
    // Estilos
    public static final String BOLD      = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    
    // Métodos helper para colores básicos
    public static String red(String txt)     { return RED + txt + RESET; }
    public static String green(String txt)   { return GREEN + txt + RESET; }
    public static String yellow(String txt)  { return YELLOW + txt + RESET; }
    public static String blue(String txt)    { return BLUE + txt + RESET; }
    public static String magenta(String txt) { return MAGENTA + txt + RESET; }
    public static String cyan(String txt)    { return CYAN + txt + RESET; }
    public static String white(String txt)   { return WHITE + txt + RESET; }
    
    // Métodos helper para colores brillantes
    public static String brightRed(String txt)     { return BRIGHT_RED + txt + RESET; }
    public static String brightGreen(String txt)   { return BRIGHT_GREEN + txt + RESET; }
    public static String brightYellow(String txt)  { return BRIGHT_YELLOW + txt + RESET; }
    public static String brightBlue(String txt)    { return BRIGHT_BLUE + txt + RESET; }
    public static String brightMagenta(String txt) { return BRIGHT_MAGENTA + txt + RESET; }
    public static String brightCyan(String txt)    { return BRIGHT_CYAN + txt + RESET; }
    public static String brightWhite(String txt)   { return BRIGHT_WHITE + txt + RESET; }
    public static String gray(String txt)          { return BRIGHT_BLACK + txt + RESET; }
    
    // Métodos para estilos
    public static String bold(String txt)      { return BOLD + txt + RESET; }
    public static String underline(String txt) { return UNDERLINE + txt + RESET; }
    
    // Métodos combinados
    public static String boldMagenta(String txt) { return BOLD + BRIGHT_MAGENTA + txt + RESET; }
    public static String boldCyan(String txt)    { return BOLD + BRIGHT_CYAN + txt + RESET; }
    public static String boldGreen(String txt)   { return BOLD + BRIGHT_GREEN + txt + RESET; }
    public static String boldRed(String txt)     { return BOLD + BRIGHT_RED + txt + RESET; }
    
    private ConsoleColor() {
    }
}