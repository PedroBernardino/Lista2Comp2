package exercicios.questao2.entidades.itens.equipamentos;

import exercicios.questao2.entidades.itens.Equipamento;

public class Espada extends Equipamento {
    private final int ataqueExtra;

    public Espada()
    {
        super();
        ataqueExtra = statusExtra;
    }

    public int getAtaqueExtra() {
        return ataqueExtra;
    }
}
