package codigodragon;

public class DanioMaximo {
    public static void main(String[] args) {

        int[] golpes = {12, 45, 8, 45, 30, 22};

        int maximo = golpes[0]; // ¿por qué NO 0?
        int posMax = 0;

        for (int i = 1; i < golpes.length; i++) {
            if (golpes[i] > maximo) {
                maximo = golpes[i];
                posMax = i;
            }
        }

    }
}
