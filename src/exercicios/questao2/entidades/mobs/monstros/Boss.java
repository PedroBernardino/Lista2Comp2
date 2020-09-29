package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

/** Classe Boss, que representa um monstro do tipo chefão.
 * <p>
 * Classe que representa um monstro chefão, um dos 4 monstros do jogo.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Boss extends Monstro {
    /**
     * Construtor da classe Boss.
     * <p>
     * Esse método é chamado ao criar uma nova instância de Boss, gerando seus status padrão.
     * @param skill a skill única do monstro.
     */
    public Boss(Skill skill) {
        super(skill);
        this.nome = "Boss";
        this.ataque = Randomizer.randomInt(2, 3);
        this.vida = 180 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
        this.status = "Imune";
        this.turnoRestanteStatus = -1;
    }
}
