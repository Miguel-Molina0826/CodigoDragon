

public class combateDaños {
}


    public static void main(String[] args) {
        int[] danios = {12, 25, 8, 30, 15, 22};
        System.out.println("El array tiene " + danios.length + " golpes registrados");
        System.out.println("El primer golpe fue de " + danios[0]);
        System.out.println("El último golpe fue de " + danios[danios.length - 1]);
        int suma = 0 ;
        for (int i = 0; i < danios.length; i++) {
            suma += danios[i];
            System.out.println("Golpe " + (i + 1) + ": " + danios[i]);
        }
        System.out.println("Daño total: " + suma );
    }

