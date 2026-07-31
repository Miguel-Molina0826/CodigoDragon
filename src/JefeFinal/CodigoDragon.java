package JefeFinal;

import java.util.Scanner;

public class CodigoDragon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje[] escuadron = null;
        int opcion = 0;

        System.out.println("==================================");
        System.out.println("  BIENVENIDO A CÓDIGO DRAGÓN");
        System.out.println("==================================");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear el escuadrón");
            System.out.println("2. Ver el escuadrón");
            System.out.println("3. Combate");
            System.out.println("4. Tienda");
            System.out.println("5. Estadísticas");
            System.out.println("6. Buscar héroe por nombre");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            // Protección en caso de que el usuario meta una letra en lugar de un número
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpieza del buffer
            } else {
                System.out.println("Entrada inválida. Ingresa un número.");
                sc.nextLine(); // Limpiar la basura
                continue;
            }

            // RESTRICCIÓN: Avisar en lugar de reventar si escuadron es nulo
            if (opcion >= 2 && opcion <= 6 && escuadron == null) {
                System.out.println("¡Aviso! Primero debes crear tu escuadrón en la Opción 1.");
                continue;
            }

            switch (opcion) {
                case 1: // 1. CREAR EL ESCUADRÓN (Array + Scanner)
                    System.out.print("¿Cuántos héroes tendrá tu escuadrón?: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine(); // Limpieza del buffer

                    if (cantidad <= 0) {
                        System.out.println("Debes crear al menos 1 héroe.");
                        break;
                    }

                    escuadron = new Personaje[cantidad];

                    for (int i = 0; i < escuadron.length; i++) {
                        escuadron[i] = new Personaje(); // new en ciclo
                        System.out.println("\n--- Ficha del Héroe " + i + " ---");

                        System.out.print("Nombre: ");
                        escuadron[i].nombre = sc.nextLine();

                        System.out.print("Clase (Ej: Mago, Arquero): ");
                        escuadron[i].clase = sc.nextLine();

                        System.out.print("Nivel: ");
                        escuadron[i].nivel = sc.nextInt();

                        System.out.print("Vida Máxima: ");
                        escuadron[i].vidaMaxima = sc.nextInt();
                        escuadron[i].vida = escuadron[i].vidaMaxima; // Inicia con la vida a tope

                        System.out.print("Ataque: ");
                        escuadron[i].ataque = sc.nextInt();

                        System.out.print("Defensa: ");
                        escuadron[i].defensa = sc.nextInt();

                        System.out.print("Oro inicial: ");
                        escuadron[i].oro = sc.nextInt();

                        escuadron[i].estaVivo = true;
                        sc.nextLine(); // Limpieza del buffer final de este héroe
                    }
                    System.out.println("¡Escuadrón creado exitosamente!");
                    break;

                case 2: // 2. VER EL ESCUADRÓN (Recorrido de array)
                    System.out.println("\n--- TU ESCUADRÓN ---");
                    for (int i = 0; i < escuadron.length; i++) {
                        System.out.print("[" + i + "] " + escuadron[i].nombre + " (" + escuadron[i].clase + ")");
                        System.out.print(" | Nivel " + escuadron[i].nivel);
                        System.out.print(" | Vida: " + escuadron[i].vida + "/" + escuadron[i].vidaMaxima);

                        if (escuadron[i].estaVivo) {
                            System.out.println(" | Estado: VIVO");
                        } else {
                            System.out.println(" | Estado: MUERTO");
                        }
                    }
                    break;

                case 3: // 3. COMBATE (While + Condicionales)
                    System.out.println("\n--- ZONA DE COMBATE ---");
                    System.out.print("Ingresa el índice del héroe para combatir (0 a " + (escuadron.length - 1) + "): ");
                    int indiceCombate = sc.nextInt();
                    sc.nextLine(); // Limpieza

                    // RESTRICCIÓN: Validar índice
                    if (indiceCombate < 0 || indiceCombate >= escuadron.length) {
                        System.out.println("Índice inválido. Héroe no encontrado.");
                        break;
                    }

                    Personaje peleador = escuadron[indiceCombate];

                    if (!peleador.estaVivo) {
                        System.out.println(peleador.nombre + " está muerto. ¡No puede pelear!");
                        break;
                    }

                    // Creación temporal de enemigo
                    int vidaEnemigo = 40;
                    int ataqueEnemigo = 12;
                    System.out.println("¡Aparece un Orco con " + vidaEnemigo + " de vida!");

                    // Ciclo hasta que uno caiga
                    while (peleador.estaVivo && vidaEnemigo > 0) {
                        // Turno del Héroe
                        System.out.println(peleador.nombre + " ataca causando " + peleador.ataque + " de daño.");
                        vidaEnemigo -= peleador.ataque;

                        if (vidaEnemigo <= 0) {
                            System.out.println("¡El Orco ha sido derrotado!");
                            peleador.oro += 15; // Recompensa
                            System.out.println(peleador.nombre + " ganó 15 de oro.");
                            break;
                        }

                        // Turno del Enemigo
                        int danoRecibido = ataqueEnemigo - peleador.defensa;
                        if (danoRecibido < 0) danoRecibido = 0; // Para no curar con defensa alta

                        System.out.println("El Orco ataca causando " + danoRecibido + " de daño.");
                        peleador.vida -= danoRecibido;

                        // RESTRICCIÓN: La vida no queda negativa
                        if (peleador.vida <= 0) {
                            peleador.vida = 0;
                            peleador.estaVivo = false;
                            System.out.println("¡" + peleador.nombre + " ha caído en combate!");
                        } else {
                            System.out.println("Vida de " + peleador.nombre + ": " + peleador.vida + "/" + peleador.vidaMaxima);
                        }
                    }
                    break;

                case 4: // 4. TIENDA (Switch + if)
                    System.out.println("\n--- TIENDA DE POCIONES ---");
                    System.out.print("Ingresa el índice del héroe que va a comprar (0 a " + (escuadron.length - 1) + "): ");
                    int indiceCompra = sc.nextInt();
                    sc.nextLine();

                    // Validar índice
                    if (indiceCompra < 0 || indiceCompra >= escuadron.length) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    Personaje comprador = escuadron[indiceCompra];

                    if (!comprador.estaVivo) {
                        System.out.println("Los héroes caídos no pueden ir de compras.");
                        break;
                    }

                    System.out.println("Oro disponible: " + comprador.oro);
                    System.out.println("1. Poción Básica (+20 Vida) - 10 Oro");
                    System.out.println("2. Súper Poción (+50 Vida) - 20 Oro");
                    System.out.print("Elige una poción: ");
                    int opcionTienda = sc.nextInt();
                    sc.nextLine();

                    int precio = 0;
                    int curacion = 0;

                    // Switch anidado para la tienda
                    switch (opcionTienda) {
                        case 1:
                            precio = 10;
                            curacion = 20;
                            break;
                        case 2:
                            precio = 20;
                            curacion = 50;
                            break;
                        default:
                            System.out.println("Opción de tienda no válida.");
                            break;
                    }

                    // Lógica IF de compra y tope de vida
                    if (precio > 0) {
                        if (comprador.oro >= precio) {
                            comprador.oro -= precio;
                            comprador.vida += curacion;

                            // RESTRICCIÓN: La vida no supera vidaMaxima
                            if (comprador.vida > comprador.vidaMaxima) {
                                comprador.vida = comprador.vidaMaxima;
                            }
                            System.out.println("Compra exitosa. Vida actual: " + comprador.vida + "/" + comprador.vidaMaxima);
                        } else {
                            System.out.println("Oro insuficiente.");
                        }
                    }
                    break;

                case 5: // 5. ESTADÍSTICAS (Los 4 patrones en un ciclo)
                    System.out.println("\n--- ESTADÍSTICAS DEL ESCUADRÓN ---");
                    int oroTotal = 0;
                    int sumaVida = 0;
                    int cantidadVivos = 0;

                    Personaje masFuerte = escuadron[0];
                    Personaje masDebil = escuadron[0];

                    for (int i = 0; i < escuadron.length; i++) {
                        // 1. Acumulador de oro y vida
                        oroTotal += escuadron[i].oro;
                        sumaVida += escuadron[i].vida;

                        // 2. Contador de vivos
                        if (escuadron[i].estaVivo) {
                            cantidadVivos++;
                        }

                        // 3 y 4. Búsqueda de mayor y menor
                        if (escuadron[i].ataque > masFuerte.ataque) {
                            masFuerte = escuadron[i];
                        }
                        if (escuadron[i].ataque < masDebil.ataque) {
                            masDebil = escuadron[i];
                        }
                    }

                    System.out.println("Total de Oro del grupo: " + oroTotal);
                    System.out.println("Héroes vivos: " + cantidadVivos + " de " + escuadron.length);
                    System.out.println("Héroe más fuerte: " + masFuerte.nombre + " (Ataque: " + masFuerte.ataque + ")");
                    System.out.println("Héroe más débil: " + masDebil.nombre + " (Ataque: " + masDebil.ataque + ")");

                    // RESTRICCIÓN: Protección contra división por cero
                    if (escuadron.length > 0) {
                        double vidaPromedio = (double) sumaVida / escuadron.length;
                        System.out.println("Vida promedio: " + vidaPromedio);
                    }
                    break;

                case 6: // 6. BUSCAR HÉROE (Bandera -1)
                    System.out.println("\n--- BÚSQUEDA DE HÉROE ---");
                    System.out.print("Ingresa el nombre del héroe a buscar: ");
                    String nombreBuscado = sc.nextLine();

                    int indiceEncontrado = -1; // Bandera

                    for (int i = 0; i < escuadron.length; i++) {
                        // RESTRICCIÓN: Textos comparados con .equalsIgnoreCase
                        if (escuadron[i].nombre.equalsIgnoreCase(nombreBuscado)) {
                            indiceEncontrado = i;
                            break; // Se detiene apenas lo encuentra
                        }
                    }

                    if (indiceEncontrado != -1) {
                        Personaje h = escuadron[indiceEncontrado];
                        System.out.println("¡Encontrado!");
                        System.out.println("Clase: " + h.clase + " | Vida: " + h.vida + "/" + h.vidaMaxima + " | Ataque: " + h.ataque + " | Oro: " + h.oro);
                    } else {
                        System.out.println("No existe ningún héroe llamado '" + nombreBuscado + "'.");
                    }
                    break;

                case 7: // 7. SALIR
                    System.out.println("\nSaliendo del juego...");
                    if (escuadron != null) {
                        System.out.println("--- RESUMEN FINAL DE LA PARTIDA ---");
                        int vivosFinal = 0;
                        int oroFinal = 0;
                        for (int i = 0; i < escuadron.length; i++) {
                            if (escuadron[i].estaVivo) vivosFinal++;
                            oroFinal += escuadron[i].oro;
                        }
                        System.out.println("Héroes que sobrevivieron: " + vivosFinal);
                        System.out.println("Oro total conseguido: " + oroFinal);
                    }
                    System.out.println("¡Gracias por jugar!");
                    break;

                default:
                    System.out.println("Opción no reconocida. Selecciona del 1 al 7.");
                    break;
            }
        } while (opcion != 7);

        sc.close();
    }
}