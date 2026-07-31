package CodigoNiveles;

import java.util.Scanner;

public class Bitacora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arreglo para guardar el oro de las 7 salas
        int[] oro = new int[7];

        // 1. Pedir el oro de cada sala
        for (int i = 0; i < oro.length; i++) {
            System.out.print("Ingrese el oro encontrado en la sala " + (i + 1) + ": ");
            oro[i] = sc.nextInt();
        }

        // 2. Mostrar la bitácora completa
        System.out.println("\n=== BITÁCORA DE ORO ===");
        for (int i = 0; i < oro.length; i++) {
            System.out.println("Sala " + (i + 1) + ": " + oro[i] + " de oro");
        }

        // 3. Calcular el oro total
        int total = 0;
        for (int i = 0; i < oro.length; i++) {
            total += oro[i];
        }

        System.out.println("\nOro total encontrado: " + total);

        // 4. Consultar una sala
        System.out.print("\nIngrese el número de una sala (1 a 7): ");
        int sala = sc.nextInt();

        if (sala >= 1 && sala <= 7) {
            System.out.println("En la sala " + sala + " había " + oro[sala - 1] + " de oro.");
        } else {
            System.out.println("Número de sala inválido.");
        }

        sc.close();
    }
}
