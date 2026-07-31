package codigodragon;

import java.util.Scanner;

public class RegistroGremio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Preguntar cantidad y crear el array
        System.out.print("¿Cuántos miembros tiene el gremio?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer

        // Pista 3: Protección si el usuario ingresa 0 miembros
        if (cantidad <= 0) {
            System.out.println("El gremio no tiene miembros para procesar.");
            return;
        }

        Personaje[] gremio = new Personaje[cantidad];

        // 2. Pedir datos de cada miembro
        for (int i = 0; i < gremio.length; i++) {
            System.out.println("\n--- Registro del Miembro " + (i + 1) + " ---");

            // Pista 1: Instanciar el objeto antes de asignar sus variables
            gremio[i] = new Personaje();

            System.out.print("Nombre: ");
            gremio[i].nombre = scanner.nextLine();

            System.out.print("Nivel: ");
            gremio[i].nivel = scanner.nextInt();

            System.out.print("Vida: ");
            gremio[i].vida = scanner.nextInt();

            System.out.print("Oro: ");
            gremio[i].oro = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el búfer tras leer números
        }

        // 3. Mostrar la tabla completa del gremio
        System.out.println("\n=============================================");
        System.out.println("            TABLA DEL GREMIO                 ");
        System.out.println("=============================================");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Nombre", "Nivel", "Vida", "Oro");
        System.out.println("---------------------------------------------");
        for (Personaje p : gremio) {
            System.out.printf("%-15s %-10d %-10d %-10.2f%n", p.nombre, p.nivel, p.vida, p.oro);
        }

        // 4. Cálculos y estadísticas
        double oroTotal = 0;
        double sumaNiveles = 0;

        // Pista 2: Guardar las posiciones (índices), no los objetos
        int posMaxVida = 0;
        int posMinVida = 0;

        for (int i = 0; i < gremio.length; i++) {
            oroTotal += gremio[i].oro;
            sumaNiveles += gremio[i].nivel;

            if (gremio[i].vida > gremio[posMaxVida].vida) {
                posMaxVida = i;
            }
            if (gremio[i].vida < gremio[posMinVida].vida) {
                posMinVida = i;
            }
        }

        double oroPromedio = oroTotal / cantidad;
        double nivelPromedio = sumaNiveles / cantidad;

        // Contar cuántos están por encima del nivel promedio
        int sobreNivelPromedio = 0;
        for (Personaje p : gremio) {
            if (p.nivel > nivelPromedio) {
                sobreNivelPromedio++;
            }
        }

        System.out.println("\n================ ESTADÍSTICAS ================");
        System.out.println("Oro total del gremio: " + oroTotal);
        System.out.printf("Oro promedio: %.2f%n", oroPromedio);
        System.out.println("Miembro con MÁS vida: " + gremio[posMaxVida].nombre + " (" + gremio[posMaxVida].vida + " HP)");
        System.out.println("Miembro con MENOS vida: " + gremio[posMinVida].nombre + " (" + gremio[posMinVida].vida + " HP)");
        System.out.printf("Nivel promedio del gremio: %.2f%n", nivelPromedio);
        System.out.println("Miembros por encima del nivel promedio: " + sobreNivelPromedio);

        // 5. Buscar un miembro por nombre
        System.out.println("\n================ BÚSQUEDA ================");
        System.out.print("Ingrese el nombre a buscar: ");
        String busqueda = scanner.nextLine();

        boolean encontrado = false;
        for (Personaje p : gremio) {
            if (p.nombre.equalsIgnoreCase(busqueda)) {
                System.out.println("\n¡Ficha Encontrada!");
                System.out.println("Nombre: " + p.nombre);
                System.out.println("Nivel: " + p.nivel);
                System.out.println("Vida: " + p.vida);
                System.out.println("Oro: " + p.oro);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El personaje '" + busqueda + "' no pertenece al gremio.");
        }

        // 6. Aplicar evento: Subsidio de oro
        System.out.println("\n================ EVENTO: SUBSIDIO ================");
        int subsidiados = 0;
        for (Personaje p : gremio) {
            if (p.nivel < 5) {
                p.oro += 50;
                subsidiados++;
            }
        }
        System.out.println("Se entregaron 50 de oro a " + subsidiados + " miembro(s) de nivel menor a 5.");

        // BONUS CREATIVO: Combate en Cadena
        System.out.println("\n================ BONUS: COMBATE EN CADENA ================");
        if (cantidad > 1) {
            int dano = 15;
            for (int i = 0; i < cantidad; i++) {
                int objetivo = (i + 1) % cantidad; // El último ataca al primero (índice 0)
                gremio[objetivo].vida -= dano;
                System.out.println(gremio[i].nombre + " ataca a " + gremio[objetivo].nombre + " causando " + dano + " de daño.");
            }

            System.out.println("\n--- Estado final de vida tras el combate ---");
            for (Personaje p : gremio) {
                System.out.println(p.nombre + " -> Vida restante: " + p.vida);
            }
        } else {
            System.out.println("Se necesitan al menos 2 miembros para iniciar el combate en cadena.");
        }
    }
}