package codigodragon;

import java.util.Scanner;

public class PorteroMazmorra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nivel del héroe: ");
        int nivel = sc.nextInt();
        System.out.print("Vida actual: ");
        int vida = sc.nextInt();
        sc.nextLine();
        System.out.print("¿Perteneces al gremio? (si/no): ");
        String gremio = sc.nextLine();

        int nivelMinimo;
        if (gremio.equalsIgnoreCase("si")) {
            nivelMinimo = 8;
        } else {
            nivelMinimo = 10;
        }
        if (nivel >= nivelMinimo && vida > 0) {
            System.out.println("Puedes entrar a la mazmorra");
        } else {
            System.out.println("ACCESO DENEGADO");
            if (nivel < nivelMinimo) {
                System.out.println("Motivo: nivel insuficiente");
            }
            if (vida <= 0) {
                System.out.println("Motivo: estás derrotado");
            }
        }
        sc.close();
    }
}
