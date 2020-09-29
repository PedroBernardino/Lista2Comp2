package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Terrestre;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;

/** Classe Carro, que representa um tipo de veículo específico carro.
 * <p>
 * Classe figurativa que envolve a concretização de um carro, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Carro extends Veiculo implements Terrestre, InteriorImpermeavel {
    public static final String nome = "Carro";
    public void andarNaEstrada() {}

    public void andarNaChuva() { }

    /**
     * Construtor da classe Carro
     * <p>
     * Esse método é chamado ao criar uma nova instância de carro, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Carro()
    {
        super(nome);
        geraPeso(650,900);
        geraVelocidade(220,250);
        passageiros = 5;
    }

}
