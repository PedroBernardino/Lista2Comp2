package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

public class Boss extends Monstro {
    public Boss(Skill skill) {
        super(skill);
        this.nome = "Boss";
        this.ataque = Randomizer.randomInt(2, 3);
        this.vida = 150 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
        this.status = "Imune";
        this.turnoRestanteStatus = -1;
    }
}
