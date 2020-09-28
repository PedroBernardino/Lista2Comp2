package exercicios.questao2.eventos;

import exercicios.questao2.entidades.Item;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.entidades.itens.equipamentos.Armadura;
import exercicios.questao2.entidades.itens.equipamentos.Espada;
import exercicios.questao2.entidades.mobs.Player;

public class EncontraItem {

    public static void pegarItem(Player heroi, Item itemAchado)
    {
        if (itemAchado instanceof Pocao)
        {
            System.out.println("Você encontrou uma Poção!");
            heroi.addPocao();
        }
        else if(itemAchado instanceof Espada)
        {
            Espada espada = (Espada) itemAchado;
            System.out.println("Você encontrou uma Espada "+ espada.getRaridade()+ "!");
            System.out.println("Seu ataque base foi aumentado em "+ espada.getAtaqueExtra());
            heroi.aumentaAtaque(espada.getAtaqueExtra());
        }
        else
        {
            Armadura armadura = (Armadura) itemAchado;
            System.out.println("Você encontrou uma Armadura "+ armadura.getRaridade() + "!");
            System.out.println("Sua vida base foi aumentado em "+ armadura.getVidaExtra());
            heroi.aumentaVida(armadura.getVidaExtra());
        }
    }
}
