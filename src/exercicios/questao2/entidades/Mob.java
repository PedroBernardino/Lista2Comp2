package exercicios.questao2.entidades;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.Entidade;
import exercicios.questao2.entidades.mobs.Skill;

/** Classe abstrata Mob, que representa um mob qualquer.
 * <p>
 * Classe figurativa que envolve a abstratificação de uma mob para tratar de capacidades e
 * características comuns a todos os mobs (players e monstros) que são abordados neste programa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Mob extends Entidade implements SerVivo {

    protected int vida, ataque, mana, vidaMax, manaMax, turnoRestanteStatus;
    protected String status, nome;

    /**
     * Construtor da classe Mob.
     * <p>
     * Esse método é chamado ao criar uma nova instância de mob, apenas gerando-o como uma entidade.
     */
    public Mob() {
        super();

    }

    /**
     * Getter do ataque do Mob.
     * <p>
     * Esse método é necessário para acessar o campo ataque da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo linha da classe.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Getter da vida do mob.
     * <p>
     * Esse método é necessário para acessar o campo vida da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo linha da classe.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Getter do mana do mob.
     * <p>
     * Esse método é necessário para acessar o campo mana da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo mana da classe.
     */
    public int getMana() {
        return mana;
    }

    /**
     * Getter do número de turnos restantes de um status aplicado ao mob.
     * <p>
     * Esse método é necessário para acessar o campo turnoRestanteStatus da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo turnoRestanteStatus da classe.
     */
    public int getTurnoRestanteStatus() {
        return turnoRestanteStatus;
    }

    /**
     * Getter do status aplicado ao mob.
     * <p>
     * Esse método é necessário para acessar o campo status da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo status da classe.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Move o mob para uma determinada posição do tabuleiro.
     * <p>
     * Esse método é responsável por mover o mob pelo tabuleiro, dada a posição (linha e coluna) da casa alvo
     * </p>
     *
     * @param lin a linha da posição alvo
     * @param col a coluna da posição alvo
     */
    public void mover(int lin, int col) {
        tabuleiro[lin][col] = this;
        tabuleiro[this.linha][this.coluna] = null;
        this.linha = lin;
        this.coluna = col;
    }

    /**
     * Ataca um inimigo com um ataque normal.
     * <p>
     * Esse método é chamado durante uma batalha. o Mob ataca um Mob inimigo recebido como parâmetro, causando seu ataque
     * como dano a vída do inimigo. Esse ataque tem 10% de chance de causar dano crítico, dobrando o dano do ataque.
     * </p>
     *
     * @param inimigo o alvo do ataque
     *
     */
    public void atacar(Mob inimigo) {
        int dano = this.ataque;
        int chanceCritico = Randomizer.randomInt(1, 100);
        if (chanceCritico <= 10) {
            System.out.println("Dano Crítico!");
            dano *= 2;
        }
        inimigo.vida -= dano;
        System.out.printf("%s ataca %s causando %d de dano.\n",this.nome,inimigo.nome, dano);
    }

    /**
     * Utiliza uma habilidade.
     * <p>
     * Esse método é chamado durante uma batalha. o Mob ataca utiliza uma habilidade , caso possua mana suficiente, e
     * então seu dano e efeito são aplicados. Retorna -1 caso o Mob nã otenha mana para utilizar a habilidade, e retorna
     * o dano causado pela habilidade ao alvo.
     * </p>
     *
     * @param skill a skill utilizada
     * @param inimigo o alvo da habilidade
     * @return -1 caso a skill não tenha sido usada, ou seu dano caso tenha sido usada corretamente.
     */
    public int usarSkill(Skill skill, Mob inimigo) {
        if (skill.getCustoMana() > mana)
            return -1;
        int dano = (int) (ataque * skill.getMultiplicadorAtaque());
        inimigo.vida -= dano;
        System.out.printf("%s utilizou %s, causando %d de dano a %s.\n",this.nome, skill.getNome(), dano, inimigo.nome);
        mana -= skill.getCustoMana();
        if(skill.getStatusAplicado().equals("Roubo de vida"))
            this.curar(dano);
        else if(skill.getStatusAplicado().equals("Abençoado"))
            skill.aplicaStatus(this);
        else if(skill.getStatusAplicado().equals("Fúria"))
            this.ataque *= 2;
        else if (skill.getStatusAplicado() != null)
            skill.aplicaStatus(inimigo);
        return dano;
    }

    /**
     * O mob se cura pela quantia dada.
     * <p>
     * O método aumenta a vida atual do jogador pela quantia recebida como parâmetro, sem ultrapassar o limite da sua
     * vida máxima.
     * </p>
     *
     * @param cura a quantia de vida curada.
     *
     */
    public void curar(int cura) {
        this.vida += cura;
        if (this.vida > this.vidaMax)
            vida = vidaMax;
    }

    /**
     * O mob restaura seu mana pela quantia dada.
     * <p>
     * O método aumenta a sua mana atual do jogador pela quantia recebida como parâmetro, sem ultrapassar o limite da sua
     * mana máxima.
     * </p>
     *
     * @param manaRestaurado a quantia de mana restaurada.
     */
    public void restaurarMana(int manaRestaurado) {
        mana += manaRestaurado;
        if (mana > manaMax)
            mana = manaMax;
    }

    /**
     * O mob recebe o status recebido como entrada.
     * <p>
     * Caso o mob não tenha nenhum status antes , ele recebe o status dado na entrada e armazena o número de turnos
     * restantes. Caso o mob já possua um status antes, o status não é aplicado.
     * </p>
     *
     * @param status o status a ser aplicado
     * @param turnosDuracao o tempo que durará esse status
     */
    public void recebeStatus(String status, int turnosDuracao) {
        if (this.status == null) {
            System.out.println("Causou " + status);
            this.status = status;
            turnoRestanteStatus = turnosDuracao;
            return;
        }
        System.out.println("Não surtiu efeito...");
    }

    /**
     * Os turnos dos status são diminuídos em 1, e seus efeitos devidamente aplicados.
     * <p>
     * Esse método ocorre ao final de casa rodada em uma batalha, diminuindo a contagem de turnos dos status dos Mobs
     * em combate e no caso de algum efeito como cura ou sangramento, estes são devidamente aplicados.
     * </p>
     *
     */
    public void passaTurno() {
        if (this.status != null) {
            if(status.equals("Sangramento")) {
                this.vida -= 10;
                System.out.println(this.nome + " perde 10 de vida devido ao sangramento.");
            }
            else if(status.equals("Abençoado"))
            {
                this.vida += 15;
                System.out.println(this.nome + " recupera 15 de vida devido a benção divina.");
            }

            turnoRestanteStatus--;
            if(turnoRestanteStatus == 0)
                limpaStatus();
        }

    }

    /**
     * Os status sem mais turnos remanescentes são apagados.
     * <p>
     * Esse método é aplicado caso o Mob possua um status com 0 turnos restantes. O status é removido e o mob torna-se
     * sem status novamente.
     * </p>
     *
     */
    public void limpaStatus() {
        System.out.println(status + " cessou.");
        status = null;
    }
}
