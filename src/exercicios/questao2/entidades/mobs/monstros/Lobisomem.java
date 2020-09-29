package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

/** Classe Lobisomem, que representa um monstro do tipo lobisomem.
 * <p>
 * Classe que representa um monstro lobisomem, um dos 4 monstros do jogo.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class Lobisomem extends Monstro {
    /**
     * Construtor da classe Boss.
     * <p>
     * Esse método é chamado ao criar uma nova instância de lobisomem, gerando seus status padrão.
     * @param skill a skill única do monstro.
     */
    public Lobisomem(Skill skill) {
        super(skill);
        this.nome = "Lobisomem";
        this.ataque = Randomizer.randomInt(10, 15);
        this.vida = 90 - ataque;
        this.mana = 50;
        vidaMax = vida;
        manaMax = mana;
    }
}
