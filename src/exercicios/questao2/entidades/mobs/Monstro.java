package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Mob;

public class Monstro extends Mob {
    public static int numerodeMonstros;
    protected Skill skill;

    public Monstro(Skill skill)

    {
        super();
        this.skill = skill;
    }

    public String getNome() {
        return nome;
    }

    public void chanceMover()
    {
        int chanceMover = Randomizer.randomInt(1,100);

        if(chanceMover <= 20)
            checaMovimento("cima");
        else if (chanceMover <= 40)
            checaMovimento("esquerda");
        else if(chanceMover <= 60)
            checaMovimento("direita");
        else if(chanceMover <= 80)
            checaMovimento("baixo");
    }

    public void checaMovimento(String direcao)
    {
        switch (direcao)
        {
            case "cima":
            {
                if(!(checaCasaOcupada(linha-1, coluna)))
                {
                    mover(linha-1, coluna);
                }
            }
            case "esquerda":
            {
                if(!(checaCasaOcupada(linha, coluna-1)))
                {
                    mover(linha, coluna-1);
                }
            }
            case "direita":
            {
                if(!(checaCasaOcupada(linha, coluna+1)))
                {
                    mover(linha, coluna+1);
                }
            }
            case "baixo":
            {
                if(!(checaCasaOcupada(linha+1, coluna)))
                {
                    mover(linha+1, coluna);
                }
            }
        }
    }
    public void decidirAtaque(Mob inimigo)
    {
        int chanceAtaque = Randomizer.randomInt(1,100);
        if(chanceAtaque <= 50 || (vida < (0.3*vidaMax)))
            if(usarSkill(skill, inimigo) == -1)
                atacar(inimigo);
        atacar(inimigo);
    }
}
