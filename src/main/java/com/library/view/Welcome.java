package com.library.view;

import static com.library.util.ConsoleColor.*;

public class Welcome {

 

    public static void show() {
        System.out.println("\n");
        System.out.println(cyan (">>> INICIALIZANDO SISTEMA DE LA BIBLIOTECA FEMINISTA..."));
        sleep(500);

        
        for (int i = 0; i <= 10; i++) {
            String barra = "=".repeat(i) + " ".repeat(10 - i);
            System.out.print(purple("\r[ " + barra + " ] " + (i * 10) + "% "));
            sleep(200);
        }

        System.out.println("\n");
        sleep(400);
        System.out.println(cyan("> Cargando archivos digitales..." ));
        sleep(600);
        System.out.println(cyan("> Descifrando narrativas feministas..." ));
        sleep(600);
        System.out.println(cyan("> Subiendo módulos de conocimiento..."));
        sleep(600);
        System.out.println(purple("> Sistema listo. Bienvenida, lectora." ));
        System.out.println("\n" + (cyan("  Comienza tu lectura." + "\n")));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
