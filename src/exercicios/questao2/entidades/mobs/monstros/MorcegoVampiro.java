package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

public class MorcegoVampiro extends Monstro {

    public MorcegoVampiro(Skill skill) {
        super(skill);
        this.nome = "Morcego Vampiro";
        this.ataque = Randomizer.randomInt(15, 20);
        this.vida = 75 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
    }
}
