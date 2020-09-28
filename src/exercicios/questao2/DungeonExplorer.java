package exercicios.questao2;

import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.entidades.itens.equipamentos.Armadura;
import exercicios.questao2.entidades.itens.equipamentos.Espada;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Player;
import exercicios.questao2.entidades.mobs.Skill;
import exercicios.questao2.entidades.mobs.monstros.Boss;
import exercicios.questao2.entidades.mobs.monstros.Lobisomem;
import exercicios.questao2.entidades.mobs.monstros.MorcegoVampiro;
import exercicios.questao2.entidades.mobs.monstros.UrsoCiborgue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonExplorer {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String entrada;
        Player heroi;
        
        boolean fimDeJogo = false;

        //Skills do Herói
        List<Skill> heroiSkills = new ArrayList<>();
        
        //Monstros
        List<Monstro> monstros;
        
        Skill sharpBlade = new Skill("Lâmina Afiada", "Envolve a espada com energia e desfere um golpe causando 120% do seu dano" +
                " e podendo aplicar sangramento por 2 turnos", 1.2, 15, "Sangramento", 80, 2);
        Skill divineBlessing = new Skill("Benção Divina", "Concede a benção sagrada ao usuário, se curando em 45 ao longo" +
                " de 3 turnos e se tornando imune a status durante esse tempo", 20, "Abençoado",3);
        Skill stunGrenade = new Skill("Granada Atordoante", "Arremessa uma granada atordoante que incapacita o inimigo" +
                " por 2 turnos. Ótima para ganhar tempo.", 20, "Atordoado", 2);

        //Skills dos Monstros
        Skill leechLife = new Skill("Sanguessuga", "Ataca com suas presas, causando 60% do seu dano e absorvendo" +
                "esse dano causo como vida para si mesmo.", 0.5, 25,"Roubo de vida", 1);

        Skill bloodClaws = new Skill("Garras Sangrentas", "Dilacera o oponente com garras ferozes que causam 90% do seu dano" +
                "e aplicam Sangramento por 3 turnos", 0.9, 20, "Sangramento", 3);

        Skill beastSwipe = new Skill ("Golpe Feral", "Acerta o inimigo com suas patas com uma imensa força, causando" +
                "80% do dano e podendo atordoar o adversário", 0.8, 30, "Atordoado", 40,1);
        Skill unstopabbleFury = new Skill("Fúria Imparável", "Libera toda sua raiva em um golpe que torna usuário" +
                "mais forte cada vez que utilizado", 0.7, 5, "Fúria", 1);


        heroiSkills.add(sharpBlade);
        heroiSkills.add(stunGrenade);
        heroiSkills.add(divineBlessing);

        do {
            Entidade.tabuleiro = new Entidade[Entidade.MAXLINHA][Entidade.MAXCOLUNA];
            //gerando as paredes no mapa.

            //paredes da borda do mapa, com coordenadas fixas
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (i == 0 || i == 11 || j == 0 || j == 11) {
                        new Parede(i, j);
                    }
                }
            }
            //paredes geradas aleatoriamente
            for (int i = 0; i < 25; i++) {
                new Parede();
            }

            //gerando os monstros no mapa
            monstros = new ArrayList<>();
            monstros.add(new MorcegoVampiro(leechLife));
            monstros.add(new Lobisomem(bloodClaws));
            monstros.add(new UrsoCiborgue(beastSwipe));
            monstros.add(new Boss(unstopabbleFury));
            Monstro.numerodeMonstros = monstros.size();


            //gerando o herói
            heroi = new Player(heroiSkills);

            //gerando os itens
            new Pocao();
            new Pocao();
            new Pocao();
            new Espada();
            new Armadura();

        }while(!ehVencivel(heroi,monstros));




        System.out.println("Bem vindo a Dungeon Explorer!");
        do {
            System.out.println("Digite o nome do seu herói:");
            heroi.setNome(scanner.nextLine());
            System.out.println("Tem certeza que deseja se chamar "+heroi.getNome()+"?   Y-sim  N-não");
        }while (!confirm(scanner));
        
        do {
            Entidade.printaTabuleiro();
            System.out.printf("%s - Ataque : %d     Hp: %d      Mana = %d\n", heroi.getNome(),heroi.getAtaque(),heroi.getVida(),heroi.getMana());
            System.out.println("Poções restantes: "+ heroi.getPocoes());
            if(heroi.getStatus() != null)
                System.out.printf("Status: %s          Turnos Restantes: %d\n", heroi.getStatus(), heroi.getTurnoRestanteStatus());
            else System.out.println("Status: Nenhum");
            System.out.println("Mover : W-cima     A-esquerda       D-direita       S-baixo");
            System.out.println("P-Usar Pocao");
            entrada = scanner.nextLine();
            //ação do jogador.
            switch (entrada) {
                case "w", "W", "cima", "frente" -> {
                    int resultado = heroi.checaMovimento("cima");
                    if (resultado == 0) {
                        System.out.println("Há uma parede nessa casa.");
                    } else if (resultado == -1) {
                        System.out.println("GAME OVER");
                        fimDeJogo = true;
                    }
                }
                case "a", "A", "esquerda" -> {
                    int resultado = heroi.checaMovimento("esquerda");
                    if (resultado == 0) {
                        System.out.println("Há uma parede nessa casa.");
                    } else if (resultado == -1) {
                        System.out.println("GAME OVER");
                        fimDeJogo = true;
                    }
                }
                case "d", "D", "direita" -> {
                    int resultado = heroi.checaMovimento("direita");
                    if (resultado == 0) {
                        System.out.println("Há uma parede nessa casa.");
                    } else if (resultado == -1) {
                        System.out.println("GAME OVER");
                        fimDeJogo = true;
                    }
                }
                case "s", "S", "tras", "trás", "baixo" -> {
                    int resultado = heroi.checaMovimento("baixo");
                    if (resultado == 0) {
                        System.out.println("Há uma parede nessa casa.");
                    } else if (resultado == -1) {
                        System.out.println("GAME OVER");
                        fimDeJogo = true;
                    }
                }
                case "p", "P", "pocao", "Pocao" -> {
                    System.out.println("Poção - "+ Pocao.getDescricao());
                    System.out.println("Deseja utilizar uma poção? Y-Sim N-Não");
                    if (DungeonExplorer.confirm(scanner)) {
                        //jogador confirma o uso da poção.
                        if (heroi.usaPocao() == -1) {
                            //jogador tenta usar poção sem ter uma.
                            System.out.println("Você não tem mais poções.");
                            continue;
                        } else System.out.println("Poção usada.");
                    }
                    else continue;
                }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            //monstros se movem pelo mapa.
            for (Monstro monstro:
                 monstros) {
                if(monstro.getVida() > 0)
                    monstro.chanceMover();
            }
            if(Monstro.numerodeMonstros == 0)
            {
                System.out.println("Todos os monstros foram derrotados, você venceu.");
                fimDeJogo = true;
            }
        }while(!fimDeJogo);

    }
    public static boolean confirm(Scanner scanner)
    {
        String acao = scanner.nextLine();
        if (acao.equals("y") || acao.equals("Y"))
            return true;
        
        if (!(acao.equals("n") || acao.equals("N"))) {
            System.out.println("Opção inválida.");
        }
        return false;
        
    }

    public static boolean ehVencivel(Player player, List<Monstro> listaMonstros)
    {
        for (Monstro monstro:
             listaMonstros) {
            if(!caminhoLivre(player, monstro)) {
                return false;
            }
        }
        return true;
    }

    public static boolean caminhoLivre(Player player,Monstro monstro)
    {
        int[][] mapa = new int[Entidade.MAXLINHA][Entidade.MAXCOLUNA];
        int linhaInicial = player.getLinha();
        int colunaInicial = player.getColuna();
        return  checaCasasVizinhas(linhaInicial,colunaInicial, mapa, monstro);
    }

    public static boolean checaCasasVizinhas(int linha, int coluna, int[][] mapa, Monstro monstro)
    {
        mapa[linha][coluna] = 1;
        if(Entidade.tabuleiro[linha][coluna] == monstro)
            return true;
        else if(Entidade.tabuleiro[linha][coluna] instanceof Parede)
            return false;
        else
        {
            boolean esquerda, direita, cima, baixo;
            if(mapa[linha-1][coluna] == 0)
            {
                cima = checaCasasVizinhas(linha-1, coluna, mapa, monstro);
            }
            else cima = false;
            if(mapa[linha][coluna-1] == 0)
            {
                esquerda = checaCasasVizinhas(linha, coluna-1, mapa, monstro);
            }
            else esquerda = false;
            if(mapa[linha][coluna+1] == 0)
            {
                direita = checaCasasVizinhas(linha, coluna+1, mapa, monstro);
            }
            else direita = false;
            if(mapa[linha+1][coluna] == 0)
            {
                baixo = checaCasasVizinhas(linha+1, coluna, mapa, monstro);
            }
            else baixo = false;
            return cima || esquerda || direita || baixo;
        }
    }
}
