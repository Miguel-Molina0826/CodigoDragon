package codigodragon;

import java.util.Scanner;

public class CazarBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nivel del héroe: ");
        int nivel = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre del arma: ");
        String arma = sc.nextLine();
        System.out.println("Nivel: " + nivel + ", empuñando: " + arma);
        sc.close();
    }
}
