package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Aquatico;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;

/** Classe Lancha, que representa um tipo de veículo específico lancha.
 * <p>
 * Classe figurativa que envolve a concretização de uma lancha, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Lancha extends Veiculo implements Aquatico, InteriorImpermeavel {
    public static final String nome = "Lancha";
    public void andarNaAgua() {}
    public void andarNaChuva() {}
    /**
     * Construtor da classe Lancha
     * <p>
     * Esse método é chamado ao criar uma nova instância de lancha, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Lancha()
    {
        super(nome);
        geraPeso(650,900);
        geraVelocidade(140,160);
        passageiros = 4;
    }
}
