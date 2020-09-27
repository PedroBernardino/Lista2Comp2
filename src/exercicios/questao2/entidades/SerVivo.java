package exercicios.questao2.entidades;

import exercicios.questao2.entidades.mobs.Skill;

public interface SerVivo {
    void mover(int linha, int coluna);
    int atacar(Mob inimigo);
    int usarSkill(Skill skill, Mob inimigo);
}
