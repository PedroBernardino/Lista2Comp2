package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Mob;

/** Classe Skill, que representa uma habilidade do jogo.
 * <p>
 * Classe que representa uma habilidade do jogo Dungeon Explorer, sendo utilizada pelo heroi ou pelos monstros do
 * mapa.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Skill {
    private final String nome, descricao, statusAplicado;
    private final double multiplicadorAtaque;
    private final int custoMana, chanceAplicarStatus, duracaoStatus;


    /**
     * Construtor da classe Skill.
     * <p>
     * Esse método é chamado ao criar uma nova instância de habilidade, recebendo como parâmetro e armazenando seu nome,
     * descrição, multiplicador de dano, custo de mana, status aplicado, chance de aplicar esse status e turnos de duração
     * do status.
     *
     * @param nome o nome da habilidade
     * @param desc a descrição da habilidade
     * @param mult o multiplicador de dano da habilidade
     * @param custo o custo de mana da habilidade
     * @param status o status que a habilidade causa
     * @param statusChance a chance de causar aquele status
     * @param turnosStatus o tempo em turnos que o status persiste
     */
    public Skill(String nome, String desc, double mult, int custo, String status, int statusChance, int turnosStatus)
    {
        this.nome = nome;
        this.descricao = desc;
        this.multiplicadorAtaque = mult;
        this.custoMana = custo;
        this.statusAplicado = status;
        this.chanceAplicarStatus = statusChance;
        this.duracaoStatus = turnosStatus;
    }

    /**
     * Construtor da classe Skill.
     * <p>
     * Esse método é chamado ao criar uma nova instância de habilidade, recebendo como parâmetro e armazenando seu nome,
     * descrição, custo de mana, status aplicado e turnos de duração do status. Esse construtor é específico pra habilidades
     * táticas, ou seja, que não causam dano, mas sua chance de aplicar seu efeito é de 100%
     *
     * @param nome o nome da habilidade
     * @param desc a descrição da habilidade
     * @param custo o custo de mana da habilidade
     * @param status o status que a habilidade causa
     * @param turnosStatus o tempo em turnos que o status persiste
     */
    public Skill(String nome, String desc, int custo, String status, int turnosStatus)
    {
        this.nome = nome;
        this.descricao = desc;
        this.multiplicadorAtaque = 0;
        this.custoMana = custo;
        this.statusAplicado = status;
        this.chanceAplicarStatus = 100;
        this.duracaoStatus = turnosStatus;
    }

    /**
     * Construtor da classe Skill.
     * <p>
     * Esse método é chamado ao criar uma nova instância de habilidade, recebendo como parâmetro e armazenando seu nome,
     * descrição, multiplicador de dano, custo de mana, status aplicado e turnos de duração do status. Esse construtor
     * é para habilidades que tem 100% de chance de aplicar seu efeito especial.
     *
     * @param nome o nome da habilidade
     * @param desc a descrição da habilidade
     * @param mult o multiplicador de dano da habilidade
     * @param custo o custo de mana da habilidade
     * @param status o status que a habilidade causa
     * @param turnosStatus o tempo em turnos que o status persiste
     */
    public Skill(String nome, String desc, double mult, int custo, String status, int turnosStatus)
    {
        this.nome = nome;
        this.descricao = desc;
        this.multiplicadorAtaque = mult;
        this.custoMana = custo;
        this.statusAplicado = status;
        this.chanceAplicarStatus = 100;
        this.duracaoStatus = turnosStatus;
    }

    /**
     * Getter do nome da habilidade.
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
     * Getter da descrição da habilidade.
     * <p>
     * Esse método é necessário para acessar o campo descricao da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo descricao da classe.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Getter do multiplicador de dano da habilidade.
     * <p>
     * Esse método é necessário para acessar o campo multiplicadorAtaque da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo multiplicadorAtaque da classe.
     */
    public double getMultiplicadorAtaque() {
        return multiplicadorAtaque;
    }

    /**
     * Getter do custo de mana da habilidade.
     * <p>
     * Esse método é necessário para acessar o campo custoMana da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo custoMana da classe.
     */
    public int getCustoMana() {
        return custoMana;
    }

    /**
     * Getter do status aplicado pela habilidade.
     * <p>
     * Esse método é necessário para acessar o campo statusAplicado da classe de fora do escopo da mesma
     * </p>
     *
     * @return O campo statusAplicado da classe.
     */
    public String getStatusAplicado() {
        return statusAplicado;
    }

    /**
     * Gera a chance de causar o status da habilidade em um inimigo
     * <p>
     * Esse método é chamado ao utilizar uma habilidade que causa um status em um alvo, e gera um número aleatório
     * para decidir se o efeito secundário foi ou não aplicado
     * </p>
     *
     * @param inimigo o alvo do status da habilidade
     */
    public void aplicaStatus(Mob inimigo)
    {
        int chanceStatus = Randomizer.randomInt(1,100);
        if(chanceStatus <= this.chanceAplicarStatus)
        {
            inimigo.recebeStatus(statusAplicado, duracaoStatus);
        }
    }
}
