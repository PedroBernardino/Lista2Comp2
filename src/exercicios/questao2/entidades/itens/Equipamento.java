package exercicios.questao2.entidades.itens;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Item;

public class Equipamento extends Item {
    protected String raridade;
    protected int statusExtra;

    public Equipamento()
    {
        super();
        int chanceRaridade = Randomizer.randomInt(1,100);
        if(chanceRaridade<= 50)
        {
            this.raridade = "Comum";
            this.statusExtra = 5;
        }
        else if(chanceRaridade<= 80)
        {
            this.raridade = "Rara";
            this.statusExtra = 10;
        }
        else if(chanceRaridade<= 95)
        {
            this.raridade = "Épica";
            this.statusExtra = 15;
        }
        else {
            this.raridade = "Lendária";
            this.statusExtra = 15;
        }
    }

    public int getStatusExtra() {
        return statusExtra;
    }

    public String getRaridade() {
        return raridade;
    }
}
