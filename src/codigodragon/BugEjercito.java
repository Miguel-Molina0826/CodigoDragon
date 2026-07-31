package codigodragon;

public class BugEjercito {
    public static void main(String[] args) {
        Heroe[] equipo = new Heroe[3];

        for (int i = 0; i < equipo.length; i++) {
            equipo[i] = new Heroe(); // Arreglo Bug 1
            equipo[i].nombre = "Héroe " + i;
            equipo[i].vida = 100;
        }

        for (int i = 0; i < equipo.length; i++) { // Arreglo Bug 2: cambio de <= a <
            System.out.println(equipo[i].nombre);
        }
    }
}