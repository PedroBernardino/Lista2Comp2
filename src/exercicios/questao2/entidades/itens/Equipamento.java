package exercicios.questao2.entidades.itens;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Item;

/** Classe abstrata Equipamento, que representa um equipamento qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de uma equipamento, para tratar de capacidades e
 * características comuns a todas os equipamentos que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Equipamento extends Item {
    protected String raridade;
    protected int statusExtra;

    /**
     * Construtor da classe Equipamento
     * <p>
     * Esse método é chamado ao criar uma nova instância de equipamento, gerando uma raridade aleatória para o item e
     * baseando seu bônus de status na mesma.
     */
    public Equipamento()
    {
        super();
        int chanceRaridade = Randomizer.randomInt(1,100);
        if(chanceRaridade<= 50)
        {
            this.raridade = "Comum";
            this.statusExtra = 5;
        }
        else if(chanceRaridade<= 80)
        {
            this.raridade = "Rara";
            this.statusExtra = 10;
        }
        else if(chanceRaridade<= 95)
        {
            this.raridade = "Épica";
            this.statusExtra = 15;
        }
        else {
            this.raridade = "Lendária";
            this.statusExtra = 20;
        }
    }

    /**
     * Getter da raridade do item
     * <p>
     * Esse método é necessário para acessar o campo raridade da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo linha da classe.
     */
    public String getRaridade() {
        return raridade;
    }
}
