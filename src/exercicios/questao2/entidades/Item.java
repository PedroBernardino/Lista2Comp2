package exercicios.questao2.entidades;

import exercicios.questao2.Entidade;

/** Classe abstrata Item, que representa uma Item qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de uma item, para tratar de capacidades e
 * características comuns a todos os itens que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Item extends Entidade {
    /**
     * Construtor da classe Item.
     * <p>
     * Esse método é chamado ao criar uma nova instância de item, apenas gerando-o como uma entidade no mapa.
     */
    public Item() {
        super();
    }
}
