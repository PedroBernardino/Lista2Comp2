package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Mob;


/** Classe abstrata Monstro, que representa uma entidade qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de um monstro, para tratar de capacidades e
 * características comuns a todos os monstros que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Monstro extends Mob {
    public static int numerodeMonstros;
    protected final Skill skill;

    /**
     * Construtor da classe Monstro.
     * <p>
     * Esse método é chamado ao criar uma nova instância de monstro, atribuindo sua skill.
     * @param skill a skill única do monstro.
     */
    public Monstro(Skill skill)
    {
        super();
        this.skill = skill;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Decide o movimento do monstro no tabuleiro.
     *
     * <p>
     *     Após cada turno do jogador, os monstros chamam esse método que decide sua ação na rodada:
     *     20% de chance de não se mover, e 20% de chance de se mover em cada uma das 4 direções.
     * </p>
     */
    public void chanceMover() {
        int rolagemMovimento = Randomizer.randomInt(1, 100);
        if (rolagemMovimento <= 20) {
            checaMovimento("cima");
            return;
        }
        if (rolagemMovimento <= 40) {
            checaMovimento("esquerda");
            return;
        }
        if (rolagemMovimento <= 60) {
            checaMovimento("direita");
            return;
        }
        if (rolagemMovimento <= 80) {
            checaMovimento("baixo");
        }
    }

    /**
     * Checa se o movimento do monstro é valido.
     *
     * <p>
     *     Recebe como entrada uma direção (cima,baixo direita ou esquerda) e ,se o monstro puder se mover para
     *     a posição desejada, ou seja, se não houver nenhuma outra entidade na posição alvejada, ativa o método que
     *     fará o monstro andar até a posição alvo.
     * </p>
     *
     * @param direcao A direção que o monstro deseja se mover.
     */
    public void checaMovimento(String direcao)
    {
        switch (direcao) {
            case "cima" -> {
                if (!(checaCasaOcupada(linha - 1, coluna))) {
                    mover(linha - 1, coluna);
                }
            }
            case "esquerda" -> {
                if (!(checaCasaOcupada(linha, coluna - 1))) {
                    mover(linha, coluna - 1);
                }
            }
            case "direita" -> {
                if (!(checaCasaOcupada(linha, coluna + 1))) {
                    mover(linha, coluna + 1);
                }
            }
            case "baixo" -> {
                if (!(checaCasaOcupada(linha + 1, coluna))) {
                    mover(linha + 1, coluna);
                }
            }
        }
    }

    /**
     * Decide a ação do monstro numa batalha
     *
     * <p>
     *     Esse método é chamado a cada turno da batalha, e decide qual ação o monstro fará.
     *     Em condições normais, o monstro tem 50% de chance de usar sua habilidade e 50% de chances de atacar,
     *     porém caso com menos de 40% de sua vida, o monstro sempre tentará usar sua habilidade.
     * </p>
     *
     * @param inimigo o Mob a ser atacado.
     */
    public void decidirAtaque(Mob inimigo)
    {
        int chanceAtaque = Randomizer.randomInt(1,100);
        if(chanceAtaque <= 50 || (vida < (0.4*vidaMax))) {
            if (usarSkill(skill, inimigo) == -1)
                atacar(inimigo);
        }
        else atacar(inimigo);
    }
}
