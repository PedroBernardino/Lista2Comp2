package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

public class Lobisomem extends Monstro {
    public Lobisomem(Skill skill) {
        super(skill);
        this.nome = "Lobisomem";
        this.ataque = Randomizer.randomInt(10, 15);
        this.vida = 70 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
    }
}
