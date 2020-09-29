package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;

/** Classe Jipe, que representa um tipo de veículo específico jipe.
 * <p>
 * Classe figurativa que envolve a concretização de um jipe, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Jipe extends Veiculo implements Terrestre, Offroad, InteriorImpermeavel {
    public static final String nome = "Jipe";
    public void andarNaEstrada() {}
    public void andarForaDaEstrada() {}
    public void andarNaChuva() {}
    /**
     * Construtor da classe Jipe
     * <p>
     * Esse método é chamado ao criar uma nova instância de jipe, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Jipe()
    {
        super(nome);
        geraPeso(580,750);
        geraVelocidade(170,190);
        passageiros = 4;
    }
}
