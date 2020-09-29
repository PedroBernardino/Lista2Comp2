package exercicios.questao1.veiculo.interfaces;

/** Interface Offroad, que representa as capacidades de um veículo capaz de andar em terreno não pavimentado
 * <p>
 * Interface que se aplica a uma instância da classe veículo que possui a capacidade de andar em terra.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public interface Offroad {
    /** Metodo que determina que um veículo é capaz de andar fora de rodovias.
     * <p>
     * A classe de veículo que implementar esta interface é considerada capaz de circular em estradas de terra e barro.
     * </p>
     */
    void andarForaDaEstrada();
}
