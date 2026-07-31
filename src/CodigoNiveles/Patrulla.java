package CodigoNiveles;

public class Patrulla {
    public static void main(String[] args) {

        Heroe[] patrulla = new Heroe[4];   // 4 casillas

        for (int i = 0; i < patrulla.length; i++) {
            patrulla[i] = new Heroe();     // La línea que casi todos olvidan
            patrulla[i].nombre = "Guardia " + (i + 1);
            patrulla[i].vida = 50 + (i * 10);
            patrulla[i].estaVivo = true;
        }

        for (int i = 0; i < patrulla.length; i++) {
            System.out.println(patrulla[i].nombre + " → vida " + patrulla[i].vida);
        }
    }
}