package exercicios.questao2.entidades;

import exercicios.questao2.Entidade;

/** Classe Parede, que representa uma parede no mapa do jogo.
 * <p>
 * Classe que representa o uma parede no tabuleiro de Dungeon Explorer, sendo considerado um obstáculo a ser contornado
 * pelo herói do jogo
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Parede extends Entidade {
    /**
     * Construtor da classe Parede.
     * <p>
     * Esse método é chamado ao criar uma nova instância de Parede, gerando uma parede em um local aleatório do mapa.
     */
    public Parede()
    {
        super();
    }
    /**
     * Construtor da classe Parede.
     * <p>
     * Esse método é chamado ao criar uma nova instância de Parede na borda do mapa, gerando uma parede na posição
     * desginada.
     *
     * @param linha linha da posição alvo
     * @param coluna coluna da posição alvo
     */
    public Parede(int linha, int coluna)
    {
        super(linha,coluna);
    }
}
