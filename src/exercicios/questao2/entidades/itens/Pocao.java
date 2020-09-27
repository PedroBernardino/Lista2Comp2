package exercicios.questao2.entidades.itens;

import exercicios.questao2.entidades.Item;
import exercicios.questao2.entidades.mobs.Player;

public class Pocao extends Item {
    private static final int curaVida = 30, curaMana = 15;
    private static final String descricao = "Cura "+ curaVida + "de vida ee "+ curaMana+ " de mana.";

    public static int getCuraMana() {
        return curaMana;
    }

    public static int getCuraVida() {
        return curaVida;
    }

    public static String getDescricao() {
        return descricao;
    }
}
