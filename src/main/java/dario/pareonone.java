/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dario;

import javax.swing.JOptionPane;

/**
 *
 * @author dario
 */
public class pareonone {

    public static void main(String[] args) {

        String opcion = "";
        String opcion2 = "";
        String opcionUsuarioParesONones;
        String opcionMaquinaParesONones;
        String ganador;
        int opcionDedos;
        int opcionDedosMaquina = 0;
        int suma = 0;

        // Se repite hasta que digamos que termine
        do {

            // Pedimos si se quiere calcular o salir
            opcion = UtilidadesJuegos.pedirOpcion();

            // Elegimos pares o nones (usuario). La máquina tiene que elegir lo contrario
            if (!opcion.equalsIgnoreCase("salir")) {

                opcionUsuarioParesONones = UtilidadesJuegos.pedirOpcionParesONones();
                opcionMaquinaParesONones = UtilidadesJuegos.pensamientoMaquinaParesONones(opcionUsuarioParesONones);
                String textoOpcionMaquinaParesONones = """
                                                                                          Has elegido %s
                                                                                          Por lo tanto, la máquina se queda con los %s""".formatted(opcionUsuarioParesONones,
                        opcionMaquinaParesONones);
                JOptionPane.showMessageDialog(null, textoOpcionMaquinaParesONones);

                //  El usuario y la máquina eligen el número de dedos (dentro del rango)
                opcionDedos = UtilidadesJuegos.pedirOpcionDedos();

                opcionDedosMaquina = UtilidadesJuegos.opcionDedosMaquina();
                String textoOpcionDedosMaquina = """
                                                                             La máquina ha elegido %d""".formatted(opcionDedosMaquina);
                JOptionPane.showMessageDialog(null, textoOpcionDedosMaquina);

                // Sumamos los resultados y vemos quién es el ganador y lo mostramos
                suma = UtilidadesJuegos.sumaDedos(opcionDedos, opcionDedosMaquina);
                ganador = UtilidadesJuegos.ganadorJuego(suma);

                String mostrarInformacion = """
                                              Has sacado %d dedos
                                              Y la máquina %d dedos
                                              Por lo tanto, la suma es %d
                                              Y ha ganado %s""".formatted(opcionDedos, opcionDedosMaquina, suma, ganador);
                JOptionPane.showMessageDialog(null, mostrarInformacion);

            } else {
                opcion = "salir";
            }
        } while (opcion.equalsIgnoreCase("jugar"));

    }
}
