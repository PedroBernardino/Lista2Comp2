package exercicios.questao2;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Player;

public abstract class Entidade {
    public static final int MAXLINHA = 12, MAXCOLUNA = 12;
    protected static Entidade[][] tabuleiro;

    protected int linha, coluna;


    protected Entidade()
    {
        this.spawn();
    }

    protected Entidade(int linha, int coluna)
    {
        this.forceSpawn(linha,coluna);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    protected void spawn()
    {
        do {
            this.linha = Randomizer.randomInt(1, 10);
            this.coluna = Randomizer.randomInt(1, 10);
        }while(checaCasaOcupada(linha,coluna));
        tabuleiro[linha][coluna] = this;
    }

    protected void forceSpawn(int linha, int coluna)
    {
        this.linha = linha;
        this.coluna = coluna;
        tabuleiro[linha][coluna] = this;
    }
    public static void printaTabuleiro()
    {
        System.out.println("-------------------------------------------------");
        System.out.println();

        for(int i = 0; i < MAXLINHA; i++)
        {
            System.out.print("                   ");
            for (int j = 0; j< MAXCOLUNA;j++)
            {
                System.out.print("   ");
                if(tabuleiro[i][j] instanceof Parede)
                    System.out.print("#");
                else if(tabuleiro[i][j] instanceof Player)
                    System.out.print("Y");
                //Para ver a localização dos itens e monstros do mapa, descomente esta parte do código.
//                else if(tabuleiro[i][j] instanceof Item)
//                    System.out.print("I");
//                else if(tabuleiro[i][j] instanceof Monstro)
//                    System.out.print("M");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Monstros restantes: "+ Monstro.numerodeMonstros);
        System.out.println("Y- Você     #-Parede");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
    protected static boolean checaCasaOcupada(int linha, int coluna)
    {
        return tabuleiro[linha][coluna] != null;
    }

}
