package exercicios.questao2.entidades;

import exercicios.questao2.entidades.mobs.Skill;

public interface SerVivo {
    void mover(int linha, int coluna);
    void atacar(Mob inimigo);
    int usarSkill(Skill skill, Mob inimigo);
    void curar(int cura);
    void recebeStatus(String status, int turnosDuracao);
    void passaTurno();
    void limpaStatus();
}
