package exercicios.questao1.veiculo.interfaces;

/** Interface InteriorImpermeavel, que representa as capacidades de um veículo capaz de isolar o inteiror de água
 * <p>
 * Interface que se aplica a uma instância da classe veículo que possui a capacidade de impedir qualquer tipo de líquido
 * que caia no veículo de chegar ao interior.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.0
 * @since       0.5
 */
public interface InteriorImpermeavel {
    /** Metodo que determina que um veículo é capaz de isolar seu interior de umidade externa.
     * <p>
     * A classe de veículo que implementar esta interface é considerada capaz de circular em dias de clima chuvoso.
     * </p>
     */
    void andarNaChuva();
}
