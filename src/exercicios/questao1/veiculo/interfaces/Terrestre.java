package exercicios.questao1.veiculo.interfaces;

/** Interface Terrestre, que representa as capacidades de um veículo capaz de andar forá da água
 * <p>
 * Interface que se aplica a uma instância da classe veículo que possui a capacidade de andar em ruas pavimentadas.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public interface Terrestre {
    /** Metodo que determina que um veículo é capaz de andar em rodovias.
     * <p>
     * A classe de veículo que implementar esta interface é considerada capaz de circular em estradas e ruas devidamente
     * pavimentadas.
     * </p>
     */
    void andarNaEstrada();
}
