package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Anfibio;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;

/** Classe TanqueAnfibio, que representa um tipo de veículo específico Tanque Anfíbio.
 * <p>
 * Classe figurativa que envolve a concretização de um tanque anfíbio, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class TanqueAnfibio extends Veiculo implements Anfibio, Offroad, InteriorImpermeavel {

    public static final String nome = "Tanque Anfíbio";
    public void andarNaEstrada() {}
    public void andarNaAgua() {}
    public void andarForaDaEstrada() {}
    public void andarNaChuva() {}
    /**
     * Construtor da classe TanqueAnfibio
     * <p>
     * Esse método é chamado ao criar uma nova instância de TanqueAnfibio, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public TanqueAnfibio()
    {
        super(nome);
        geraPeso(1500,2000);
        geraVelocidade(50,70);
        passageiros = 2;
    }
}
