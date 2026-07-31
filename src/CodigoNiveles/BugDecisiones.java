package CodigoNiveles;

import java.util.Scanner;

public class BugDecisiones {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


        System.out.print("Escribe tu clase (guerrero/mago): ");
        String clase = sc.nextLine();
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        if (clase .equalsIgnoreCase( "guerrero")) {
            System.out.println("Tienes armadura pesada");
        }
        if (nivel >= 10)
        {
            System.out.println("Puedes usar magia avanzada");
        }
        switch (nivel) {
            case 1:
                System.out.println("Novato");
                break;
            case 2:
                System.out.println("Aprendiz");
                break;
            case 3:
                System.out.println("Veterano");
                break;
        }
        sc.close();
    }

}
