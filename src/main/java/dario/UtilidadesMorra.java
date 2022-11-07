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
public class UtilidadesMorra {
    
    private static Random aleatorio = new Random();
    
    // Pedimos si se quiere jugar o salir y comprobamos que esté bien
    
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
    
    public static String pedirOpcion(){
        String opcion;
        do {            
                opcion = mostrarMenuInicial();
        } while (!esOpcionMenuInicialValida(opcion));
        return opcion;
    }
    
    // Pedimos el número de dedos y comprobamos que esté dentro del rango
    
    public static int pedirOpcionDedos(){
        
        String texto="""
                               Elige el número de dedos (1-5)
                                """;
        
        int opcionDedos = 0;
        do {
            try {
                opcionDedos = Integer.parseInt(JOptionPane.showInputDialog(texto));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"No has introducido "
                        + "el número de dedos correctamente");
            }
            
        } while (esOpcionDedosValida(opcionDedos));
        return opcionDedos;
        
    }
    
    public static boolean esOpcionDedosValida(int opcionDedos){
        return 1 > opcionDedos || opcionDedos > 5;
    }
    
    // Creamos el método en el que el usuario tiene que decir cuánto cree que será la suma
    
    public static int supuestaSumaUsuario(){
        
        int supuestaSuma = 0;
        
        String textoSupuestaSuma="""
                                                         Introduce cúal crees que será la suma entre tus dedos y los de la
                                                         máquina (máximo 10)""";
        do {            
            try {
                supuestaSuma = Integer.parseInt(JOptionPane.showInputDialog(textoSupuestaSuma));
            } catch (NumberFormatException nfe2) {
                JOptionPane.showMessageDialog(null, "No has introducido tu suposición "
                        + "de suma correctamente");
            }
        } while (esSupuestaSumaUsuarioValida(supuestaSuma));
        return supuestaSuma;
    }
    
    public static boolean esSupuestaSumaUsuarioValida(int supuestaSuma){       
        return 1 > supuestaSuma || supuestaSuma > 10;    
    }
    
    // Creamos la elección aleatoria de la máquina de dedos
    
    public static int opcionDedosMaquina() {

        int aleatorio2 = 0;
        aleatorio2 = aleatorio.nextInt(1, 6);
        return aleatorio2;

    }
    
    // Creamos la elección aleatorio de la máquina de la suma de dedos
    
    public static int supuestaSumaMaquina(){
        int aleatorio3 = 0;
        aleatorio3 = aleatorio.nextInt(1,10);
        return aleatorio3;
    }
    
    public static int sumaDedos(int pedirOpcionDedos, int opcionDedosMaquina){
        int suma = pedirOpcionDedos + opcionDedosMaquina;
        return suma;
    }
    
    // Creamos el método que decide quién es el ganador
    
    public static String ganador(int sumaDedos, int supuestaSumaUsuario, int supuestaSumaMaquina){
        
        String ganador="";
        
        if (sumaDedos == supuestaSumaUsuario) {
            ganador = "usuario";            
        }
        if (sumaDedos == supuestaSumaMaquina) {
            ganador = "máquina";            
        }
        if (sumaDedos !=supuestaSumaUsuario && sumaDedos !=supuestaSumaMaquina ) {
            ganador="ninguno";            
        }
        return ganador;
    }
}
