/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dario;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dario
 */
public class UtilidadesJuegos {

    private static Random aleatorio = new Random();
    
    // JUEGO PAREONONE
    // Pedimos si se va a jugar o a terminar y comprobamos que esté bien
    public static String mostrarMenuInicial() {

        String texto = """
                          ----------------------------------------------------------------
                                                    MENÚ
                          ----------------------------------------------------------------
                          Para jugar, escribe: jugar
                          Para terminar el programa, escribe: salir
                          ----------------------------------------------------------------""";

        String opcion = JOptionPane.showInputDialog(texto);
        return opcion;
    }

    public static boolean esOpcionMenuInicialValida(String opcion) {

        return opcion.equalsIgnoreCase("jugar") || opcion.equalsIgnoreCase("salir");

    }

    public static String pedirOpcion() {
        String opcion;
        do {
            opcion = mostrarMenuInicial();
        } while (!esOpcionMenuInicialValida(opcion));
        return opcion;

    }

    // Pedimos si quieres elegir pares o nones y comprobamos que esté bien
    public static String mostrarMenuParesONones() {

        String texto = """
                                 ----------------------------------------------------------------
                                 Para elegir par, escribe: pares
                                 Para elegir none, escribe: nones
                                 ---------------------------------------------------------------- """;
        String opcion2 = JOptionPane.showInputDialog(texto);
        return opcion2;
    }

    public static boolean esOpcionMenuParesONonesValida(String opcion2) {
        return opcion2.equalsIgnoreCase("pares") || opcion2.equalsIgnoreCase("nones");
    }

    public static String pedirOpcionParesONones() {
        String opcion2;
        do {
            opcion2 = mostrarMenuParesONones();
        } while (!esOpcionMenuParesONonesValida(opcion2));
        return opcion2;
    }

    // La maquina elegirá lo contrario a lo que escoja el usuario
    public static String pensamientoMaquinaParesONones(String opcion2) {
        String opcionMaquinaParesONones = "";
        if (opcion2.equalsIgnoreCase("pares")) {
            opcionMaquinaParesONones = "nones";
        } else {
            opcionMaquinaParesONones = "pares";
        }
        return opcionMaquinaParesONones;
    }

    public static int pedirOpcionDedos() {

        String texto = """
                                 ----------------------------------------------------------------
                                 Elige el número de dedos (1-5)
                                 ---------------------------------------------------------------- """;
        int opcionDedos = 0;
        do {
            try {
                opcionDedos = Integer.parseInt(JOptionPane.showInputDialog(texto));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "No has introducido "
                        + "el número correctamente");
            }
        } while (esOpcionDedosValida(opcionDedos));
        return opcionDedos;
    }

    public static boolean esOpcionDedosValida(int opcionDedos) {
        return 1 > opcionDedos || opcionDedos > 5;
    }

    public static int opcionDedosMaquina() {

        int aleatorio2 = 0;
        aleatorio2 = aleatorio.nextInt(1, 6);
        return aleatorio2;

    }

    public static int sumaDedos(int pedirOpcionDedos, int opcionDedosMaquina) {
        int suma = pedirOpcionDedos + opcionDedosMaquina;
        return suma;
    }

    public static String ganadorJuego(int sumaDedos) {
        String ganador = "";

        if (sumaDedos % 2 == 0) {
            ganador = "usuario";
        } else {
            ganador = "maquina";
        }
        return ganador;
    }
    
    // JUEGO LA MORRA

}
