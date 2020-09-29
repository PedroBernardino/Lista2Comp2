package exercicios.questao2.entidades.itens.equipamentos;

import exercicios.questao2.entidades.itens.Equipamento;

/** Classe Espada, que representa um item equipável do tipo espada.
 * <p>
 * Classe que representa uma espada utilizável pelo herói do jogo, se o mesmo encontrar o item pelo mapa
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Espada extends Equipamento {
    private final int ataqueExtra;

    /**
     * Construtor da classe Espada.
     * <p>
     * Esse método é chamado ao criar uma nova instância de Espada, gerando o status de ataque que será adicionado ao
     * ataque base do jogador
     */
    public Espada()
    {
        super();
        ataqueExtra = statusExtra;
    }

    public int getAtaqueExtra() {
        return ataqueExtra;
    }
}
