package exercicios.questao2;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.mobs.Player;

public abstract class Entidade {
    private static final int MAXLINHA = 12, MAXCOLUNA = 12;
    protected static Entidade[][] tabuleiro = new Entidade[MAXLINHA][MAXCOLUNA];

    protected int linha, coluna;


    protected Entidade()
    {
        this.Spawn();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    protected void Spawn()
    {
        do {
            this.linha = Randomizer.randomInt(1, 10);
            this.coluna = Randomizer.randomInt(1, 10);
        }while(checaCasaOcupada(linha,coluna));
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
                System.out.print(" ");
                if(tabuleiro[i][j] instanceof Parede)
                    System.out.print("X");
                else if(tabuleiro[i][j] instanceof Player)
                    System.out.print("P");
                else if(tabuleiro[i][j] == null)
                    System.out.print("_");
                else System.out.print("?");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
    protected static boolean checaCasaOcupada(int linha, int coluna)
    {
        return tabuleiro[linha][coluna] != null;
    }

}
