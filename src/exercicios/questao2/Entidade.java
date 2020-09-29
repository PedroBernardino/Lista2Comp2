package exercicios.questao2;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Player;

/** Classe abstrata Entidade, que representa uma entidade qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de uma entidade, para tratar de capacidades e
 * características comuns a todas as entidades que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Entidade {
    public static final int MAXLINHA = 12, MAXCOLUNA = 12;
    protected static Entidade[][] tabuleiro;

    protected int linha, coluna;

    /**
     * Construtor da classe Entidade.
     * <p>
     * Esse método é chamado ao criar uma nova instância de entidade, chamando o método spawn para a mesma.
     */
    protected Entidade()
    {
        this.spawn();
    }

    /**
     * Construtor da classe Entidade.
     * <p>
     * Esse método é chamado ao criar uma nova instância de entidade, recebendo uma posição (linha e coluna)
     * chamando o método forceSpawn para a mesma , passando esses atributos recebidos.
     *
     * @param linha a linha da posição desejada
     * @param coluna a coluna da posição desejada
     */
    protected Entidade(int linha, int coluna)
    {
        this.forceSpawn(linha,coluna);
    }

    /**
     * Getter da linha da posição da entidade.
     * <p>
     * Esse método é necessário para acessar o campo linha da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo linha da classe.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Getter da coluna da posição da entidade.
     * <p>
     * Esse método é necessário para acessar o campo coluna da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo coluna da classe.
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Método que gera uma entidade no tabuleiro.
     * <p>
     * Esse método é chamado dentro do construtor ao criar uma nova instância de entidade,
     * e ao ser acionado ele gera valores aleatórios para linha e coluna (em intervalos dentro do tabuleiro) e, caso
     * essa posição esteja vazia, insere a entidade no tabuleiro. Esse processo é repetido até a entidade ser inserida
     * com sucesso no tabuleiro.
     */
    protected void spawn()
    {
        do {
            this.linha = Randomizer.randomInt(1, MAXLINHA-2);
            this.coluna = Randomizer.randomInt(1, MAXCOLUNA-2);
        }while(checaCasaOcupada(linha,coluna));
        tabuleiro[linha][coluna] = this;
    }

    /**
     * Método que gera uma entidade no tabuleiro forçadamente.
     * <p>
     * Esse método é chamado dentro do construtor ao criar uma nova instância de entidade,
     * e ao ser acionado ele recebe valores de linha e coluna especificos , e insere a entidade na posição do tabuleiro
     * forçadamente, antes mesmo de checar se a posição está vazia. Método perigoso , utilizado somente para a criação
     * das paredes das bordas do mapa.
     *
     * @param linha linha da posição que a entidade deve ser gerada
     * @param coluna coluna da posição que a entidade deve ser gerada
     */
    protected void forceSpawn(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
        tabuleiro[linha][coluna] = this;
    }

    /**
     * Método que printa o tabuleiro na tela.
     * <p>
     * Esse método é chamado a cada turno em que o usuário for tomar uma ação, mostrando ao mesmo a sua posição atual
     * no tabuleiro e as casas que possuem uma parede.
     */
    public static void printaTabuleiro()
    {
        System.out.println("-------------------------------------------------");
        System.out.println();

        for(int i = 0; i < MAXLINHA; i++)
        {
            System.out.print("                   ");
            for (int j = 0; j< MAXCOLUNA;j++)
            {
                System.out.print("   ");
                if(tabuleiro[i][j] instanceof Parede)
                    System.out.print("#");
                else if(tabuleiro[i][j] instanceof Player)
                    System.out.print("Y");
                //Para ver a localização dos itens e monstros do mapa, descomente esta parte do código.
//                else if(tabuleiro[i][j] instanceof Item)
//                    System.out.print("I");
//                else if(tabuleiro[i][j] instanceof Monstro)
//                    System.out.print("M");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Monstros restantes: "+ Monstro.numerodeMonstros);
        System.out.println("Y- Você     #-Parede");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
    /**
     * Método que checa se uma casa do tabuleiro está ocupada.
     * <p>
     * Esse método recebe uma posição (linha e coluna) e checa se essa posição do tabuleiro possui uma entidade ou não.
     * Retorna true caso a posição tenha uma entidade, e false caso esteja vazia.
     *
     * @param linha a linha da posição que será checada.
     * @param coluna a coluna da posição que será checada.
     *
     * @return se a casa da posição está vazia ou não.
     */
    protected static boolean checaCasaOcupada(int linha, int coluna)
    {
        return tabuleiro[linha][coluna] != null;
    }

}
