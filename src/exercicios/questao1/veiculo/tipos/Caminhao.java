package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Terrestre;

/** Classe Caminhao, que representa um tipo de veículo específico caminhão.
 * <p>
 * Classe que envolve a concretização de um caminhão, para tratar de capacidades e
 * características comuns a todos os caminhões que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Caminhao extends Veiculo implements Terrestre, InteriorImpermeavel {
    public static final String nome = "Caminhao";
    public void andarNaEstrada() {}
    public void andarNaChuva() {}
    /**
     * Construtor da classe Caminhao.
     * <p>
     * Esse método é chamado ao criar uma nova instância de caminhao, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Caminhao()
    {
        super(nome);
        geraPeso(4000,5000);
        geraVelocidade(90,110);
        passageiros = 3;
    }
}
