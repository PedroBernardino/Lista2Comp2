package exercicios.questao1.veiculo;

import exercicios.auxiliar.Randomizer;
import exercicios.questao1.veiculo.interfaces.Aquatico;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;


/** Classe abstrata veículo, que representa um veículo qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de um veículo, para tratar de capacidades e
 * características comuns a todos os veículos que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       0.5
 */
public abstract class Veiculo {
    protected final String nomeTipo;
    protected double velocidadeMax;
    protected double pesoMax;
    protected int passageiros = 0;

    /**
     * Construtor da classe Veículo.
     * <p>
     * Esse método é chamado ao criar uma nova instância de veículo, atribuindo o nome passado como entrada ao seu campo
     * nome.
     * </p>
     * @param nome Nome do tipo de veículo.
     */
    public Veiculo(String nome)
    {
        this.nomeTipo = nome;
    }

    /**
     * Getter do nome do tipo do veículo.
     * <p>
     * Esse método é necessário para acessar o campo nomeTipo da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo nomeTipo da classe.
     */
    public String getNomeTipo() {
        return nomeTipo;
    }

    /**
     * Getter da velocidade máxima.
     * <p>
     * Esse método é necessário para acessar o campo velocidadeMax da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo velocidadeMax da classe.
     */
    public double getVelocidadeMax()
    {
        return this.velocidadeMax;
    }

    /**
     * Getter do peso máximo.
     * <p>
     * Esse método é necessário para acessar o campo pesoMax da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo pesoMax da classe.
     */
    public double getPesoMax()
    {
        return this.pesoMax;
    }

    /**
     * Getter do número de passageiros.
     * <p>
     * Esse método é necessário para acessar o campo passageiros da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo passageiros da classe.
     */
    public int getPassageiros() {
        return passageiros;
    }

    /**
     * Calcula o tempo necessário para realizar uma viagem com este veículo.
     * <p>
     * O método calcula em qual o tempo mínimo necessário para realizar a viagem dado a distância do trajeto, tendo
     * a velocidade máxima do veículo como campo próprio da classe, e assumindo que a velocidade média do veículo
     * durante o trajeto é   Vmédia = Vmax / 2. O cálculo do tempo necessário é baseado na fórmula:
     *
     *  Vmédia = distância/ tempo
     *
     *  Tempo = distância / Vmédia.
     * </p>
     *
     * @param distancia a distância do trajeto da viagem.
     * @return O tempo necessário mínimo para a viagem.
     */
    protected double calculaTempoViagem(double distancia)
    {
        double velocidadeMedia = this.velocidadeMax/2;
        return distancia / velocidadeMedia;
    }

    /**
     * Verifica se o veículo atende as especificações requisitadas.
     * <p>
     * Esse método recebe como entrada a distância do trajeto, o tipo do terreno, o número de passageiros,
     * o peso da carga, o tempo limite e o clima do dia da viagem. Dadas essas informações, o método retorna
     * se o veículo é capaz de realizar a viagem de acordo com suas próprias características e capacidades.
     * </p>
     * @param distancia A distância do trajeto da viagem em Km.
     * @param tipoCaminho O terreno pelo qual o veículo irá realizar a viagem.
     * @param pesoCarga O peso da bagagem da viagem.
     * @param numPessoas O número de pessoas que fará a viagem.
     * @param  tempoLimite O tempo máximo para a duração da viagem.
     * @param clima O clima no dia da viagem, se fará chuva ou sol.
     *
     * @return O tempo mínimo necessário para relizar a viagem.
     */
    public boolean verifica(double distancia, String tipoCaminho, int numPessoas, double pesoCarga, double tempoLimite, String clima)
    {
        if (this.calculaTempoViagem(distancia) > tempoLimite) {
            return false;
        }
        if (tipoCaminho.equals("rodovia") && !(this instanceof Terrestre)) {
            return false;
        }
        if(tipoCaminho.equals("estrada de terra") && !(this instanceof Offroad)) {
            return false;
        }
        if((tipoCaminho.equals("rio") || tipoCaminho.equals("lago") || tipoCaminho.equals("mar")) && !(this instanceof Aquatico)) {
            return false;
        }
        if (numPessoas > this.passageiros) {
            return false;
        }
        if(pesoCarga > this.pesoMax) {
            return false;
        }
        if(clima.equals("chuva") && !(this instanceof InteriorImpermeavel)) {
            return false;
        }

        return true;
    }

    /**
     * Gerador da velocidade máxima.
     * <p>
     * Esse método gera um valor aleatório para a velocidade máxima dentro de um determinado intervalo.
     * </p>
     *
     * @param min o valor mínimo dentro do intervalo.
     * @param max o valor máximo dentro do intervalo.
     */
    protected void geraVelocidade(double min, double max)
    {
        this.velocidadeMax = Randomizer.randomDouble(min,max);
    }

    /**
     * Gerador do peso máximo.
     * <p>
     * Esse método gera um valor aleatório para o peso máximo dentro de um determinado intervalo.
     * </p>
     *
     * @param min o valor mínimo dentro do intervalo.
     * @param max o valor máximo dentro do intervalo.
     */
    protected void geraPeso(double min,double max)
    {
        this.pesoMax = Randomizer.randomDouble(min,max);
    }
}
