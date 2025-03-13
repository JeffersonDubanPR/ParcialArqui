package org.example;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Telefonica> cabinas = new ArrayList<>();
        int opcion, idCabina, tipoLlamada, minutos;

        do {
            System.out.println("\n Menú Principal");
            System.out.println("1️ Crear cabina");
            System.out.println("2️ Registrar llamada");
            System.out.println("3️ Mostrar información de una cabina");
            System.out.println("4️ Mostrar consolidado total");
            System.out.println("5️ Reiniciar una cabina");
            System.out.println("6️ Salir");
            System.out.print(" Eliga una Opcion  ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    int nuevaId = cabinas.size() + 1;
                    cabinas.add(new Telefonica(nuevaId));
                    System.out.println("\n Cabina " + nuevaId + " creada");
                }
                case 2 -> {
                    if (cabinas.isEmpty()) {
                        System.out.println("\n No hay cabinas creadas.");
                        continue;
                    }
                    System.out.print("\n Ingresa el número de cabina: ");
                    idCabina = scanner.nextInt();
                    if (idCabina < 1 || idCabina > cabinas.size()) {
                        System.out.println("\n Cabina no válida");
                        continue;
                    }
                    System.out.println("\n 1.Local $50 minuto  )");
                    System.out.println("\n 2. Larga Distancia $350 minuto");
                    System.out.println("\n 3. Celular $150 minuto");
                    System.out.print("Tipo de llamada ");
                    tipoLlamada = scanner.nextInt();
                    System.out.print("Duración en minutos");
                    minutos = scanner.nextInt();
                    cabinas.get(idCabina - 1).registrarLlamada(tipoLlamada, minutos);
                }
                case 3 -> {
                    if (cabinas.isEmpty()) {
                        System.out.println("\n No hay cabinas creadas.");
                        continue;
                    }
                    System.out.print("\n Ingresa el número de cabina: ");
                    idCabina = scanner.nextInt();
                    if (idCabina < 1 || idCabina > cabinas.size()) {
                        System.out.println("\n Cabina no válida.");
                        continue;
                    }
                    cabinas.get(idCabina - 1).mostrarInfo();
                }
                case 4 -> {
                    if (cabinas.isEmpty()) {
                        System.out.println("\n No hay cabinas creadas");
                        continue;
                    }
                    int totalMinutos = 0, totalCosto = 0;
                    for (Telefonica c : cabinas) {
                        totalMinutos += c.getMinutosLocales() + c.getMinutosLargaDistancia() + c.getMinutosCelular();
                        totalCosto += c.getCostoTotal();
                    }
                    System.out.println("\n Consolidado Total");
                    System.out.println(" 1.Total de minutos: " + totalMinutos);
                    System.out.println(" 2. Costo total: $" + totalCosto);
                }
                case 5 -> {
                    if (cabinas.isEmpty()) {
                        System.out.println("\n No hay cabinas creadas");
                        continue;

                    }
                    System.out.println("\n Ingrese Numero de Cabina");
                    idCabina = scanner.nextInt();
                    if (idCabina < 1 || idCabina > cabinas.size()) {
                        System.out.println("\n Cabina no válida.");
                        continue;
                    }
                    cabinas.get(idCabina - 1).reiniciar();
                }
                case 6 -> System.out.println("\n Gracias por usar la Cabina");
                default -> System.out.println("\nOpción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}













