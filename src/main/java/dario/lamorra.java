/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dario;

import javax.swing.JOptionPane;

/**
 *
 * @author dario
 */
public class lamorra {

    public static void main(String[] args) {

        String opcion = "";
        String ganador;

        int opcionDedos;
        int opcionDedosMaquina;
        int supuestaSumaUsuario;
        int supuestaSumaMaquina;
        int suma;

        // Se repite hasta que digamos que termine
        do {
            // Pedimos si se quiere calcular o salir
            opcion = UtilidadesMorra.pedirOpcion();

            if (!opcion.equalsIgnoreCase("salir")) {
                
                // Se piden los dedos que se quieren sacar
                
                opcionDedos = UtilidadesMorra.pedirOpcionDedos();

                // Se pide la que el usuario crea que vaya a ser la suma entre sus dedos y los de la máquina
                
                supuestaSumaUsuario = UtilidadesMorra.supuestaSumaUsuario();
                
                // La máquina aleatoriamente elige su número de dedos

                opcionDedosMaquina = UtilidadesMorra.opcionDedosMaquina();

                String textoOpcionDedosMaquina = """
                                                                             La máquina ha sacado %d dedos""".formatted(
                        opcionDedosMaquina);

                JOptionPane.showMessageDialog(null, textoOpcionDedosMaquina);
                
                // La máquina aleatoriamente elige la que cree que será la suma entre los dedos del usuario y
                // la máquina
                
                supuestaSumaMaquina = UtilidadesMorra.supuestaSumaMaquina();

                String textoSupuestaSumaMaquina = """
                                                                                La máquina cree que la suma será de %d dedos""".formatted(
                        supuestaSumaMaquina);

                JOptionPane.showMessageDialog(null, textoSupuestaSumaMaquina);
                
                // Se calcula la suma entre los dedos del usuario y los de la máquina
                
                suma = UtilidadesMorra.sumaDedos(opcionDedos, opcionDedosMaquina);

                String textoSuma = """
                                                 La suma de los dedos es %d""".formatted(suma);

                JOptionPane.showMessageDialog(null, textoSuma);
                
                // Se obtiene y se muestra el ganador
                
                ganador = UtilidadesMorra.ganador(suma, supuestaSumaUsuario, supuestaSumaMaquina);

                String textoGanador = """
                                                      El ganador del juego es %s""".formatted(ganador);
                JOptionPane.showMessageDialog(null, textoGanador);

            } else {
                opcion = "salir";
            }

        } while (opcion.equalsIgnoreCase("jugar"));

    }

}
