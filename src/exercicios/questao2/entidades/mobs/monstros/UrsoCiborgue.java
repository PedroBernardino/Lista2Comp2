package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

public class UrsoCiborgue extends Monstro {
    public UrsoCiborgue(Skill skill) {
        super(skill);
        this.nome = "Urso Ciborgue";
        this.ataque = Randomizer.randomInt(7, 12);
        this.vida = 120 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
    }
}
