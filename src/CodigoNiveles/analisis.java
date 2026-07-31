
package CodigoNiveles;

import java.util.Scanner;

public class analisis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] oroMeses = new double[12];
        double totalAnual = 0;

        // 1. Pida los 12 valores con un for
        System.out.println("=== REGISTRO DE ORO ANUAL ===");
        for (int i = 0; i < oroMeses.length; i++) {
            System.out.print("Ingrese el oro ganado en el mes " + (i + 1) + ": ");
            oroMeses[i] = scanner.nextDouble();
            totalAnual += oroMeses[i]; // Acumulamos para el total
        }

        // 2. Muestre el total anual y el promedio mensual (cuidado con el casting con double)
        double promedioMensual = totalAnual / 12.0;
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Total anual: " + totalAnual);
        System.out.println("Promedio mensual: " + promedioMensual);

        // 3. Indique el mejor mes (número y valor) y el peor mes
        double mejorValor = oroMeses[0];
        int mejorMes = 1;
        double peorValor = oroMeses[0];
        int peorMes = 1;

        for (int i = 1; i < oroMeses.length; i++) {
            if (oroMeses[i] > mejorValor) {
                mejorValor = oroMeses[i];
                mejorMes = i + 1;
            }
            if (oroMeses[i] < peorValor) {
                peorValor = oroMeses[i];
                peorMes = i + 1;
            }
        }

        System.out.println("Mejor mes: Mes " + mejorMes + " con " + mejorValor);
        System.out.println("Peor mes: Mes " + peorMes + " con " + peorValor);

        // 4. Cuente cuántos meses estuvieron por encima del promedio
        int mesesEncimaPromedio = 0;
        for (int i = 0; i < oroMeses.length; i++) {
            if (oroMeses[i] > promedioMensual) {
                mesesEncimaPromedio++;
            }
        }
        System.out.println("Meses por encima del promedio: " + mesesEncimaPromedio);

        // 5. Pida un valor y busque si algún mes ganó exactamente ese oro
        System.out.print("\nIngrese una cantidad de oro a buscar: ");
        double oroBusqueda = scanner.nextDouble();
        boolean encontrado = false;

        System.out.print("Resultado de la búsqueda: ");
        for (int i = 0; i < oroMeses.length; i++) {
            if (oroMeses[i] == oroBusqueda) {
                System.out.print("Mes " + (i + 1) + " ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No ocurrió (ningún mes tuvo exactamente esa cantidad).");
        } else {
            System.out.println("(fueron los meses encontrados)");
        }

        // 6. Muestre la diferencia entre el mejor y el peor mes
        double diferencia = mejorValor - peorValor;
        System.out.println("Diferencia entre el mejor y el peor mes: " + diferencia);

        scanner.close();
    }
}
