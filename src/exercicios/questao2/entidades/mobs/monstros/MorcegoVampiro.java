package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;


/** Classe MorcegoVampiro, que representa um monstro do tipo Morcego Vampiro.
 * <p>
 * Classe que representa um monstro Morcego Vampiro, um dos 4 monstros do jogo.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class MorcegoVampiro extends Monstro {

    /**
     * Construtor da classe Morcego Vampiro
     * <p>
     * Esse método é chamado ao criar uma nova instância de morcego vampiro, gerando seus status padrão.
     * @param skill a skill única do monstro.
     */
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
