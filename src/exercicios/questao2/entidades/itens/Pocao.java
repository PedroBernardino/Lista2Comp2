package exercicios.questao2.entidades.itens;

import exercicios.questao2.entidades.Item;

/** Classe Pocao, que representa uma Poção de vida e mana.
 * <p>
 * Classe que representa uma poção que o protagonista obtém ao fim de uma batalha ou ao encontrar no mapa,e regenera
 * sua vida e mana.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Pocao extends Item {
    private static final int curaVida = 30, curaMana = 15;
    private static final String descricao = "Cura "+ curaVida + " de vida e "+ curaMana+ " de mana.";

    /**
     * Getter da cura de mana da poção.
     * <p>
     * Esse método é necessário para acessar o campo curaMana da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo curaMana da classe.
     */
    public static int getCuraMana() {
        return curaMana;
    }

    /**
     * Getter da cura de vida da poção.
     * <p>
     * Esse método é necessário para acessar o campo curaVida da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo curaVida da classe.
     */
    public static int getCuraVida() {
        return curaVida;
    }

    /**
     * Getter da descrição da poção.
     * <p>
     * Esse método é necessário para acessar o campo descricao da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo descricao da classe.
     */
    public static String getDescricao() {
        return descricao;
    }
}
