package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Mob;

public class Skill {
    private final String nome, descricao, statusAplicado;
    private final double multiplicadorAtaque;
    private final int custoMana, chanceAplicarStatus, duracaoStatus;


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

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getMultiplicadorAtaque() {
        return multiplicadorAtaque;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public String getStatusAplicado() {
        return statusAplicado;
    }

    public void aplicaStatus(Mob inimigo)
    {
        int chanceStatus = Randomizer.randomInt(1,100);
        if(chanceStatus <= this.chanceAplicarStatus)
        {
            inimigo.recebeStatus(statusAplicado, duracaoStatus);
        }
    }
}
