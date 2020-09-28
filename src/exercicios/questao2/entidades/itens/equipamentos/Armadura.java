package exercicios.questao2.entidades.itens.equipamentos;

import exercicios.questao2.entidades.itens.Equipamento;

public class Armadura extends Equipamento {
    private final int vidaExtra;

    public Armadura()
    {
        super();
        vidaExtra = 2*statusExtra;
    }

    public int getVidaExtra() {
        return vidaExtra;
    }
}
