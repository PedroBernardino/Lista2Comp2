package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Aquatico;

/** Classe Canoa, que representa um tipo de veículo específico canoa.
 * <p>
 * Classe figurativa que envolve a concretização de uma canoa, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Canoa extends Veiculo implements Aquatico {
    public static final String nome = "Canoa";
    public void andarNaAgua() {}

    /**
     * Construtor da classe Canoa
     * <p>
     * Esse método é chamado ao criar uma nova instância de canoa, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Canoa()
    {
        super(nome);
        geraPeso(350,420);
        geraVelocidade(40,60);
        passageiros = 2;
    }
}
