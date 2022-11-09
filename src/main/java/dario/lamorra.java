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
        int rondasGanadasUsuario = 0;
        int rondasGanadasMaquina = 0;
        int rondasEmpatadas = 0;

        // Se repite hasta que digamos que termine
        do {
            // Pedimos si se quiere calcular o salir
            opcion = UtilidadesMorra.pedirOpcion();

            if (!opcion.equalsIgnoreCase("salir")) {

                do {
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
                    supuestaSumaMaquina = UtilidadesMorra.supuestaSumaMaquina(opcionDedosMaquina);

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
                    ganador = UtilidadesMorra.ganador(suma, supuestaSumaUsuario,
                            supuestaSumaMaquina, opcionDedosMaquina);

                    if (ganador.equalsIgnoreCase("usuario")) {

                        rondasGanadasUsuario = rondasGanadasUsuario + 1;

                    } else if (ganador.equalsIgnoreCase("maquina")) {

                        rondasGanadasMaquina = rondasGanadasMaquina + 1;

                    } else if (!ganador.equalsIgnoreCase("usuario") && !ganador.equalsIgnoreCase("maquina")) {

                        rondasEmpatadas = rondasEmpatadas + 1;

                    }

                    String textoGanadorRonda = """
                                                      El ganador de la ronda es %s""".formatted(ganador);
                    JOptionPane.showMessageDialog(null, textoGanadorRonda);

                    String textoGanadorControl = """
                                                                    El usuario lleva %d rondas ganadas
                                                                    La máquina lleva %d rondas ganadas
                                                                    Se han empatado %d rondas""".formatted(rondasGanadasUsuario,
                            rondasGanadasMaquina, rondasEmpatadas);

                    JOptionPane.showMessageDialog(null, textoGanadorControl);

                    if (rondasGanadasUsuario == 3) {

                        JOptionPane.showMessageDialog(null, "Has ganado la partida");

                    } else if (rondasGanadasMaquina == 3) {

                        JOptionPane.showMessageDialog(null, "La máquina ha ganado la partida");

                    }

                } while (rondasGanadasUsuario < 3 && rondasGanadasMaquina < 3);

            } else {
                opcion = "salir";
            }

        } while (opcion.equalsIgnoreCase("jugar"));

    }

}
