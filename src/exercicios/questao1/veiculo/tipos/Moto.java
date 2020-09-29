package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Terrestre;

/** Classe Moto, que representa um tipo de veículo específico moto.
 * <p>
 * Classe figurativa que envolve a concretização de uma moto, para tratar de capacidades e
 * características comuns a todos os canoas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Moto extends Veiculo implements Terrestre {
    public static final String nome = "Moto";
    public void andarNaEstrada() { }
    /**
     * Construtor da classe Moto
     * <p>
     * Esse método é chamado ao criar uma nova instância de moto, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Moto()
    {
        super(nome);
        geraPeso(150,200);
        geraVelocidade(130,150);
        passageiros = 2;
    }
}
