package codigodragon;

import java.util.Scanner;

public class RegistroGremio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre completo del aventurero: ");
        String nombreCompleto = sc.nextLine();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        System.out.println("Vida base: ");
        int vidaBase = sc.nextInt();
        System.out.println("Ataque base: ");
        int ataqueBase = sc.nextInt();
        System.out.println("Defensa base: ");
        int defensaBase = sc.nextInt();
        System.out.println("Oro inicial: ");
        double oroInicial = sc.nextDouble();
        sc.nextLine();
        System.out.println("Clase del aventurero: ");
        String clase = sc.nextLine();

        System.out.println("============Registro========================");
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Edad: " + edad);
        System.out.println("Vida base: [||||||] " + vidaBase);
        System.out.println("Ataque base: " + ataqueBase);
        System.out.println("Defensa base: " + defensaBase);
        System.out.println("Oro inicial: " + oroInicial);
        System.out.println("Clase del aventurero: " + clase);
        System.out.println("==============Ficha==========================");

        int poderDeCombate = ataqueBase * 3 + defensaBase * 2;
        int nivelEstimado = vidaBase / 10;
        double oroRestante = (oroInicial - 50);

        System.out.println("Poder de combate: " + poderDeCombate);
        System.out.println("Nivel estimado: " + nivelEstimado);
        System.out.println("Oro tras pagar la inscripción: " + oroRestante);
        System.out.println("=============================================");
        sc.close();
    }
}
