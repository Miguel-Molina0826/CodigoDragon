package CodigoNiveles;

public class Mazmorra {
    public static void main(String[] args) {

        // Goblin
        String goblinNombre = "Goblin";
        int goblinVida = 50;
        int goblinAtaque = 10;
        double goblinRecompensaOro = 25.5;
        boolean goblinEsJefe = false;

        // Dragon
        String dragonNombre = "Dragon";
        int dragonVida = 300;
        int dragonAtaque = 40;
        double dragonRecompensaOro = 500.0;
        boolean dragonEsJefe = true;

        System.out.println("Enemigos en la mazmorra:");
        System.out.println("- " + goblinNombre + " (vida " + goblinVida + ")");
        System.out.println("- " + dragonNombre + " (vida " + dragonVida + ")");

        if (dragonEsJefe) {
            System.out.println(dragonNombre + " es un JEFE. ¡Cuidado!");
        }
    }
}
