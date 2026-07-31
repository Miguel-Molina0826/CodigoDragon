package codigodragon;
import java.util.Scanner;
public class TiendaPociones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Oro disponible: ");
        int oro = sc.nextInt();
        System.out.print("Vida disponible: ");
        int vida = sc.nextInt();

        System.out.println("\n===== TIENDA =====");
        System.out.println("1. Poción pequeña (20 oro)");
        System.out.println("2. Poción grande (50 oro)");
        System.out.println("3. Elixir de fuerza (120 oro)");
        System.out.println("4. Salir");

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        int precio = 0;
        int aumentoVida = 0;
        int aumentoAtaque = 0;
        String producto = "";

        switch (opcion) {

            case 1:
                producto = "Poción pequeña";
                precio = 20;
                aumentoVida = 30;
                break;

            case 2:
                producto = "Poción grande";
                precio = 50;
                aumentoVida = 80;
                break;

            case 3:
                producto = "Elixir de fuerza";
                precio = 120;
                aumentoAtaque = 10;
                break;

            case 4:
                System.out.println("Hasta luego.");
                sc.close();
                return;

            default:
                System.out.println("Opción inválida.");
                sc.close();
                return;
        }

        if (oro >= precio) {

            oro -= precio;

            vida += aumentoVida;

            if (vida > 150) {
                vida = 150;
                System.out.println("Vida al máximo");
            }

            System.out.println("\nCompra realizada.");
            System.out.println("Producto: " + producto);

            if (aumentoVida > 0) {
                System.out.println("Vida +" + aumentoVida);
            }

            if (aumentoAtaque > 0) {
                System.out.println("Ataque +" + aumentoAtaque);
            }

        } else {

            System.out.println("\nNo tienes oro suficiente.");
            System.out.println("Te faltan " + (precio - oro) + " monedas.");
        }

        System.out.println("\n===== ESTADO FINAL =====");
        System.out.println("Oro: " + oro);
        System.out.println("Vida: " + vida);

        sc.close();
    }

}


