package exercicios.questao1.veiculo.interfaces;

/** Interface Aquatico, que representa as capacidades de um veículo aquático.
 * <p>
 * Interface que se aplica a uma instância da classe veículo que possui a capacidade de andar na água.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public interface Aquatico {

    /** Metodo que determina que um veículo é capaz de andar na Água.
     * <p>
     * A classe de veículo que implementar esta interface é considerada capaz de andar em rios, lagos ou oceanos.
     * </p>
     */
    void andarNaAgua();
}
