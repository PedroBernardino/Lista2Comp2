package exercicios.questao2.entidades.itens.equipamentos;

import exercicios.questao2.entidades.itens.Equipamento;

/** Classe Armadura, que representa um item equipável do tipo armadura.
 * <p>
 * Classe que representa uma armadura utilizável pelo herói do jogo, se o mesmo encontrar o item pelo mapa
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Armadura extends Equipamento {
    private final int vidaExtra;
    /**
     * Construtor da classe Armadura.
     * <p>
     * Esse método é chamado ao criar uma nova instância de Armadura, gerando o status de vida que será adicionado à
     * vida base do jogador
     */
    public Armadura()
    {
        super();
        vidaExtra = 2*statusExtra;
    }

    public int getVidaExtra() {
        return vidaExtra;
    }
}
