package exercicios.auxiliar;

import java.util.Random;

public class Randomizer {
    public static double randomDouble(double minimo, double maximo)
    {
        Random random = new Random();
        return minimo + (maximo - minimo) * random.nextDouble();
    }
}
