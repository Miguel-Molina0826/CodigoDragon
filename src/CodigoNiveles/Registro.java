package CodigoNiveles;

import java.util.Scanner;

public class Registro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserta el nombre que quieras: ");
        String nombre = sc.nextLine();

        System.out.print(" Edad ");
        byte edad  = sc.nextByte();

        System.out.print(" Vida base  ");
        byte vidaInicial  = sc.nextByte();

        System.out.print(" Ataque base  ");
        byte ataqueInicial = sc.nextByte();

        System.out.print(" Defensa base   ");
        byte defensaInicial = sc.nextByte();


        System.out.print(" oro inicial: ");
        double oroDisponible = sc.nextDouble();

        System.out.print(" Guerrero, Mago o Arquero: ");
        String tipoPersonaje = sc.nextLine();


        System.out.println("Nombre: " + nombre);
        System.out.println(" Edad: " + edad);
        System.out.println("vida inicial: " + vidaInicial);
        System.out.println("Oro: " + oroDisponible);
        System.out.println(" Ataque base : " + ataqueInicial);
        System.out.println(" Defensa base : " + defensaInicial);
        System.out.println(" tipo de personaje: " + tipoPersonaje);


        sc.close();
    }
}