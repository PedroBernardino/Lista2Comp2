package exercicios.questao2.eventos;

import exercicios.questao2.entidades.Item;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.entidades.itens.equipamentos.Armadura;
import exercicios.questao2.entidades.itens.equipamentos.Espada;
import exercicios.questao2.entidades.mobs.Player;

/** Classe abstrata EncontraItem, que representa um evento em que um jogador encontra um item.
 * <p>
 * Classe figurativa que envolve a abstratificação de um jogador encontrando um item pelo mapa, seja ele espada, armadura
 * ou uma poção.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class EncontraItem {

    /**
     * Dá o item encontrado ao jogador.
     * <p>
     * Esse método é acionado quando um jogador entra numa casa com um item. Caso o item seja um equipamento, o jogador
     * o equipa imediatamente, e caso seja uma poção, adiciona ao seu estoque de poções.
     * </p>
     *
     * @param heroi o jogador que encontrou o item
     * @param itemAchado o item encontrado pelo jogador
     *
     */
    public static void pegarItem(Player heroi, Item itemAchado)
    {
        if (itemAchado instanceof Pocao)
        {
            System.out.println("Você encontrou uma Poção!");
            heroi.addPocao();
        }
        else if(itemAchado instanceof Espada)
        {
            Espada espada = (Espada) itemAchado;
            System.out.println("Você encontrou uma Espada "+ espada.getRaridade()+ "!");
            System.out.println("Seu ataque base foi aumentado em "+ espada.getAtaqueExtra());
            heroi.aumentaAtaque(espada.getAtaqueExtra());
        }
        else
        {
            Armadura armadura = (Armadura) itemAchado;
            System.out.println("Você encontrou uma Armadura "+ armadura.getRaridade() + "!");
            System.out.println("Sua vida base foi aumentado em "+ armadura.getVidaExtra());
            heroi.aumentaVida(armadura.getVidaExtra());
        }
    }
}
