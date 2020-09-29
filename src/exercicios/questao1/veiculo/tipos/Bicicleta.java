package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;

/** Classe Bicicleta, que representa um tipo de veículo específico bicicleta.
 * <p>
 * Classe que envolve a concretização de uma bicicleta, para tratar de capacidades e
 * características comuns a todas as bicicletas que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public class Bicicleta extends Veiculo implements Terrestre, Offroad {

    private static final String nome = "Bicicleta";

    public void andarNaEstrada() { }

    public void andarForaDaEstrada() { }

    /**
     * Construtor da classe Bicicleta.
     * <p>
     * Esse método é chamado ao criar uma nova instância de bicicleta, gerando uma velocidade
     * e pesos aleatórios dentro de um determinado intervalo e setando o nome do veículo e o número
     * de passageiros.
     * </p>
     */
    public Bicicleta()
    {
        super(nome);
        geraPeso(90,140);
        geraVelocidade(50,60);
        passageiros = 1;

    }
    
}
