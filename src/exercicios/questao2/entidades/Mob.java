package exercicios.questao2.entidades;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.Entidade;
import exercicios.questao2.entidades.mobs.Skill;


public abstract class Mob extends Entidade implements SerVivo {

    protected int vida, ataque, mana, vidaMax, manaMax, turnoRestanteStatus;
    protected String status, nome;

    public Mob() {
        super();

    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getTurnoRestanteStatus() {
        return turnoRestanteStatus;
    }

    public String getStatus() {
        return status;
    }

    public void mover(int lin, int col) {
        tabuleiro[lin][col] = this;
        tabuleiro[this.linha][this.coluna] = null;
        this.linha = lin;
        this.coluna = col;
    }

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

    public void curar(int cura) {
        this.vida += cura;
        if (this.vida > this.vidaMax)
            vida = vidaMax;
    }

    public void restaurarMana(int manaRestaurado) {
        mana += manaRestaurado;
        if (mana > manaMax)
            mana = manaMax;
    }

    public void recebeStatus(String status, int turnosDuracao) {
        if (this.status == null) {
            System.out.println("Causou " + status);
            this.status = status;
            turnoRestanteStatus = turnosDuracao;
            return;
        }
        System.out.println("Não surtiu efeito...");
    }

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

    public void limpaStatus() {
        System.out.println(status + " cessou.");
        status = null;
    }
}
