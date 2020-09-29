package exercicios.questao2.entidades.mobs.monstros;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Skill;

/** Classe UrsoCiborgue, que representa um monstro do tipo Urso Ciborgue.
 * <p>
 * Classe que representa um monstro Urso Ciborgue, um dos 4 monstros do jogo.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public class UrsoCiborgue extends Monstro {

    /**
     * Construtor da classe Urso Ciborgue
     * <p>
     * Esse método é chamado ao criar uma nova instância de urso ciborgue, gerando seus status padrão.
     * @param skill a skill única do monstro.
     */
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
