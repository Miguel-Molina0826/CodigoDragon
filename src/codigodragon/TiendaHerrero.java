package codigodragon;

import java.util.Scanner;

public class TiendaHerrero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas monedas de oro tienes?: ");
        double oroDisponible = sc.nextDouble();

        System.out.print("Precio de la espada: ");
        double precioEspada = sc.nextInt();

        System.out.print("¿Cuántas espadas quieres? ");
        int cantidad = sc.nextInt();

        sc.nextLine();      // ← ¿hace falta limpiar aquí? Piénsalo

        System.out.print("Nombre del arma personalizada: ");
        String nombreArma = sc.nextLine();

        double costoTotal = precioEspada * cantidad;
        double oroRestante = costoTotal - oroDisponible;

        System.out.println("Compraste " + cantidad + " x " + nombreArma);
        System.out.println("Gastaste: " + costoTotal);
        System.out.println("Te quedan: " + oroRestante + " de oro");

        sc.close();
    }
}
