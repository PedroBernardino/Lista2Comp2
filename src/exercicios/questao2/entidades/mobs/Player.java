package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.Entidade;
import exercicios.questao2.entidades.Item;
import exercicios.questao2.entidades.Mob;
import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.eventos.Batalha;
import exercicios.questao2.eventos.EncontraItem;

import java.util.List;
import java.util.Objects;

/** Classe Player, que representa o heroi do jogo.
 * <p>
 * Classe que representa o protagonista de Dungeon Exlorer, implementando suas características e ações no jogo.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Player extends Mob {
    private final List<Skill> skills;
    private int pocoes;

    /**
     * Construtor da classe Player.
     * <p>
     * Esse método é chamado ao criar uma nova instância de jogador, recebendo como parâmetro uma lista de Skill, que
     * serão suas habilidades. Após isso, seus status são gerados aleatóriamente dentro de um intervalo.
     *
     * @param skills a lista de habilidades que serão do jogador
     */
    public Player(List <Skill> skills) {
        super();
        this.skills = skills;
        this.ataque = Randomizer.randomInt(15, 20);
        this.vida = 100 - ataque;
        this.mana = 50;
        this.pocoes = 0;
        vidaMax = vida;
        manaMax = mana;
    }


    /**
     * Setter do nome do jogador.
     * <p>
     * Esse método é necessário para alterar o campo nome do jogador.
     * </p>
     *
     * @param nome o nome desejado para o jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do nome do jogador.
     * <p>
     * Esse método é necessário para acessar o campo nome da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo nome da classe.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter da quantidade de poções do jogador.
     * <p>
     * Esse método é necessário para acessar o campo pocoes da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo pocoes da classe.
     */
    public int getPocoes() {
        return pocoes;
    }

    /**
     * Getter da lista de habilidades do jogador
     * <p>
     * Esse método é necessário para acessar o campo skills da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo skills da classe.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Checa se o movimento do jogador é valido.
     *
     * <p>
     *     Recebe como entrada uma direção (cima,baixo direita ou esquerda) e ,se o jogador puder se mover para
     *     a posição desejada, ou seja, se não houver uma parede na posição alvejada, ativa o método que
     *     fará o monstro andar até a posição alvo.
     *     Retorna 1 caso consiga andar normalmente,ou seja, caso não haja uma entidade na casa alvo, caso haja um item na
     *     casa alvo ou se houver um monstro na casa alvo, e o heroi vencer a batalha.
     *     Retorna 0 se houver um monstro na casa alvo, e o herói fugir da batalha.
     *     Retorna -1 se houver uma parede na casa alvo.
     *
     *     @return 1, 0 ou -1, dependendo da entidade que estiver na posição alvejada e da interação do protagonista com ela.
     * </p>
     *
     * @param direcao a direção que o jogador deseja andar.
     */
    public int checaMovimento(String direcao) {
        switch (direcao) {
            case "cima" -> {
                if (!(checaCasaOcupada(this.linha - 1, this.coluna))) {
                    this.mover(linha - 1, coluna);
                    return 1;
                } else {
                    Entidade alvo = tabuleiro[linha - 1][coluna];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha - 1, coluna);
                        return 1;
                    } else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha - 1, coluna);
                        }
                        else if (resultadoBatalha == -1)
                            return -2;
                        return 1;
                    }
                }

            }
            case "esquerda" -> {
                if (!(checaCasaOcupada(this.linha, this.coluna - 1))) {
                    this.mover(linha, coluna - 1);
                    return 1;
                } else {
                    Entidade alvo = tabuleiro[linha][coluna - 1];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha, coluna - 1);
                        return 1;
                    }
                    else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha, coluna - 1);
                        }
                        else if(resultadoBatalha == -1)
                            return resultadoBatalha;
                        return 1;
                    }
                }
            }
            case "direita" -> {
                if (!(checaCasaOcupada(this.linha, this.coluna + 1))) {
                    this.mover(linha, coluna + 1);
                    return 1;
                }
                else {
                    Entidade alvo = tabuleiro[linha][coluna + 1];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha, coluna + 1);
                        return 1;
                    } else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha, coluna + 1);
                        }
                        else if(resultadoBatalha == -1)
                            return resultadoBatalha;
                        return 1;
                    }
                }
            }
            case "baixo" -> {
                if (!(checaCasaOcupada(this.linha + 1, this.coluna))) {
                    this.mover(linha + 1, coluna);
                } else {
                    Entidade alvo = tabuleiro[linha + 1][coluna];
                    if (alvo instanceof Parede)
                        return 0;

                    if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha + 1, coluna);
                        return 1;

                    }
                    int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                    if (resultadoBatalha == 1)
                        this.mover(linha + 1, coluna);
                    else if (resultadoBatalha == -1)
                        return resultadoBatalha;
                }
                return 1;
            }
        }
        return 0;
    }

    /**
     * Realiza uma tentativa de fuga da batalha
     *
     * <p>
     *     Recebe como parâmetro o inimigo com o qual o jogador está batalhando, e tenta realizar uma fuga.
     *     As chances de fugir são de 70%, ou 100% caso o inimigo esteja atordoado. Retorna 1 caso a fuga seja bem-sucedida,
     *     e -1 caso contrário
     * </p>
     *
     * @param inimigo o inimigo em batalha do qual se deseja fugir
     *
     * @return 1 caso o protagonista consiga fugir, -1 caso não.
     */
    public int fugir(Monstro inimigo)
    {
        int chanceFuga = Randomizer.randomInt(1,100);
        if(chanceFuga <= 70 || Objects.equals(inimigo.getStatus(), "Atordoado"))
        {
            return 1;
        }
        else return -1;
    }

    /**
     * Aumenta o ataque base do protagonista.
     *
     * <p>
     *     Esse método é chamado caso o protagonista adquira um item do tipo Espada, que aumenta seu status de ataque.
     * </p>
     *
     * @param aumento a quantidade de ataque que será aumentado.
     */
    public void aumentaAtaque(int aumento)
    {
        this.ataque += aumento;
    }

    /**
     * Aumenta a vida base do protagonista.
     *
     * <p>
     *     Esse método é chamado caso o protagonista adquira um item do tipo Armadura, que aumenta seu status de vida.
     * </p>
     *
     * @param aumento a quantidade de vida que será aumentada.
     */
    public void aumentaVida(int aumento)
    {
        this.vida += aumento;
        this.vidaMax += aumento;
    }

    /**
     * Aumenta o número de poções do jogador em 1.
     *
     * <p>
     *     Esse método é chamado caso o protagonista adquira um item do Poção, que aumenta o número de poções que ele
     *     carrega consigo.
     * </p>
     */
    public void addPocao()
    {
        this.pocoes++;
    }

    /**
     * Utiliza uma das poções do jogador
     *
     * <p>
     *     O heroi usa uma de suas poções, caso possua uma. O método retorna 1 caso o protagonista consiga usar uma poção,
     *     e -1 se ele não tiver nenhuma para usar.
     * </p>
     * @return 1 caso a poção seja usada , e -1 caso o jogador não tenha poções para usar
     */
    public int usaPocao()
    {
        if(this.pocoes == 0)
            return -1;
        this.curar(Pocao.getCuraVida());
        this.restaurarMana(Pocao.getCuraMana());
        this.pocoes --;
        return 1;
    }
}
