package exercicios.auxiliar;

import java.util.Random;

/** Classe abstrata Randomizer responsável por gerar números aleatórios.
 * <p>
 * Classe capaz de gerar números inteiros e decimais aleatórios dentro de determinado intervalo atevés
 * do package java.util.Random.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.1
 * @since       0.5
 */
public abstract class Randomizer {

    /**
     * Gera um número decimal aleatório.
     * <p>
     * Essa função gera um número double aleatório em um intervalo específico
     * dado nos parâmetros de entrada.
     * </p>
     *
     *
     * @param  minimo o menor número possível dentro do intervalo.
     * @param  maximo o maior número possível dentro do intervalo.
     * @return O número aleatório gerado.
     */
    public static double randomDouble(double minimo, double maximo)
    {
        Random random = new Random();
        return minimo + (maximo - minimo) * random.nextDouble();
    }

    /**
     * Gera um número inteiro aleatório.
     * <p>
     * Essa função gera um número int aleatório em um intervalo específico
     * dado nos parâmetros de entrada.
     * </p>
     *
     *
     * @param  minimo o menor número possível dentro do intervalo.
     * @param  maximo o maior número possível dentro do intervalo.
     * @return O número aleatório gerado.
     */
    public static int randomInt(int minimo, int maximo)
    {
        Random random = new Random();
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }
}
