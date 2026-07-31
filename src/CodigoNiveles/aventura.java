package CodigoNiveles;

import java.util.Scanner;

public class aventura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Personaje 1 (Datos fijos)
        String p1Nombre = "Aragorn";
        String p1Clase = "Guerrero";
        int p1Nivel = 10;
        int p1VidaMaxima = 150;
        int p1Vida = 150;
        int p1Ataque = 25;
        int p1Defensa = 15;
        double p1Oro = 100.0;
        boolean p1EstaVivo = true;

        // Personaje 2 (Datos fijos)
        String p2Nombre = "Gandalf";
        String p2Clase = "Mago";
        int p2Nivel = 12;
        int p2VidaMaxima = 100;
        int p2Vida = 100;
        int p2Ataque = 30;
        int p2Defensa = 10;
        double p2Oro = 250.0;
        boolean p2EstaVivo = true;

        // Personaje 3 (Pedido por Scanner)
        System.out.println("--- Registro del tercer personaje ---");
        System.out.print("Nombre: ");
        String p3Nombre = scanner.nextLine();
        System.out.print("Clase: ");
        String p3Clase = scanner.nextLine();
        System.out.print("Nivel: ");
        int p3Nivel = scanner.nextInt();
        System.out.print("Vida Máxima: ");
        int p3VidaMaxima = scanner.nextInt();
        int p3Vida = p3VidaMaxima;
        System.out.print("Ataque: ");
        int p3Ataque = scanner.nextInt();
        System.out.print("Defensa: ");
        int p3Defensa = scanner.nextInt();
        System.out.print("Oro: ");
        double p3Oro = scanner.nextDouble();
        boolean p3EstaVivo = true;

        // 2. Muestra la ficha de los tres
        System.out.println("\n=== FICHAS DE LOS PERSONAJES ===");
        System.out.println("1. " + p1Nombre + " | Clase: " + p1Clase + " | Nivel: " + p1Nivel + " | Vida: " + p1Vida + "/" + p1VidaMaxima + " | Ataque: " + p1Ataque + " | Defensa: " + p1Defensa + " | Oro: " + p1Oro + " | Vivo: " + p1EstaVivo);
        System.out.println("2. " + p2Nombre + " | Clase: " + p2Clase + " | Nivel: " + p2Nivel + " | Vida: " + p2Vida + "/" + p2VidaMaxima + " | Ataque: " + p2Ataque + " | Defensa: " + p2Defensa + " | Oro: " + p2Oro + " | Vivo: " + p2EstaVivo);
        System.out.println("3. " + p3Nombre + " | Clase: " + p3Clase + " | Nivel: " + p3Nivel + " | Vida: " + p3Vida + "/" + p3VidaMaxima + " | Ataque: " + p3Ataque + " | Defensa: " + p3Defensa + " | Oro: " + p3Oro + " | Vivo: " + p3EstaVivo);

        // 3. Calcula el poder (poder = ataque * 3 + defensa * 2 + nivel * 10)
        int poder1 = p1Ataque * 3 + p1Defensa * 2 + p1Nivel * 10;
        int poder2 = p2Ataque * 3 + p2Defensa * 2 + p2Nivel * 10;
        int poder3 = p3Ataque * 3 + p3Defensa * 2 + p3Nivel * 10;

        System.out.println("\n--- PODER DE COMBATE ---");
        System.out.println(p1Nombre + " - Poder: " + poder1);
        System.out.println(p2Nombre + " - Poder: " + poder2);
        System.out.println(p3Nombre + " - Poder: " + poder3);

        if (poder1 >= poder2 && poder1 >= poder3) {
            System.out.println("¡El personaje con el poder más alto es " + p1Nombre + "!");
        } else if (poder2 >= poder1 && poder2 >= poder3) {
            System.out.println("¡El personaje con el poder más alto es " + p2Nombre + "!");
        } else {
            System.out.println("¡El personaje con el poder más alto es " + p3Nombre + "!");
        }

        // 4. Simula un ataque: p1 golpea a p3
        System.out.println("\n--- SIMULACIÓN DE ATAQUE ---");
        System.out.println(p1Nombre + " ataca a " + p3Nombre + "!");
        int danioReal = p1Ataque - p3Defensa;
        if (danioReal < 0) {
            danioReal = 0;
        }

        p3Vida -= danioReal;
        if (p3Vida <= 0) {
            p3Vida = 0;
            p3EstaVivo = false;
        }
        System.out.println("Daño real infligido: " + danioReal);

        // 5. Muestra el estado de los tres después del ataque
        System.out.println("\n=== ESTADO DESPUÉS DEL ATAQUE ===");
        System.out.println("1. " + p1Nombre + " - Vida: " + p1Vida + "/" + p1VidaMaxima + " | Vivo: " + p1EstaVivo);
        System.out.println("2. " + p2Nombre + " - Vida: " + p2Vida + "/" + p2VidaMaxima + " | Vivo: " + p2EstaVivo);
        System.out.println("3. " + p3Nombre + " - Vida: " + p3Vida + "/" + p3VidaMaxima + " | Vivo: " + p3EstaVivo);

        // 6. Cura al personaje 3 en 30 puntos sin pasarse de su vidaMaxima
        System.out.println("\n--- CURACIÓN ---");
        p3Vida += 30;
        if (p3Vida > p3VidaMaxima) {
            p3Vida = p3VidaMaxima;
        }
        if (p3Vida > 0) {
            p3EstaVivo = true;
        }
        System.out.println("Se ha curado a " + p3Nombre + ". Vida actual: " + p3Vida + "/" + p3VidaMaxima);

        scanner.close();
    }
}