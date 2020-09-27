package exercicios.auxiliar;

import java.util.Random;

public class Randomizer {
    public static double randomDouble(double minimo, double maximo)
    {
        Random random = new Random();
        return minimo + (maximo - minimo) * random.nextDouble();
    }
    public static int randomInt(int minimo, int maximo)
    {
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }
}
