package com.library.view;

public class Welcome {

    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public static void show() {
        System.out.println("\n");
        System.out.println(CYAN + ">>> INICIALIZANDO SISTEMA DE LA BIBLIOTECA FEMINISTA..." + RESET);
        sleep(500);

        
        for (int i = 0; i <= 10; i++) {
            String barra = "=".repeat(i) + " ".repeat(10 - i);
            System.out.print(PURPLE + "\r[ " + barra + " ] " + (i * 10) + "% " + RESET);
            sleep(200);
        }

        System.out.println("\n");
        sleep(400);
        System.out.println(CYAN + "> Cargando archivos digitales..." + RESET);
        sleep(600);
        System.out.println(CYAN + "> Descifrando narrativas feministas..." + RESET);
        sleep(600);
        System.out.println(CYAN + "> Subiendo módulos de conocimiento..." + RESET);
        sleep(600);
        System.out.println(PURPLE + "> Sistema listo. Bienvenida, lectora." + RESET);
        System.out.println("\n" + CYAN + "  Comienza tu lectura." + RESET + "\n");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
