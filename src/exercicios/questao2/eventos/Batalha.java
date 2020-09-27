package exercicios.questao2.eventos;

import exercicios.auxiliar.Randomizer;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Player;
import exercicios.questao2.entidades.mobs.Skill;

import java.util.Scanner;

public class Batalha {

    public static int lutar(Player player, Monstro monster)
    {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Batalha.printarStatus(player, monster);
            if(!player.getStatus().equals("Atordoado")) { //verifica se o jogador não está atordoado

                String acao = scanner.nextLine(); // le a próxima ação do jogador
                switch (acao) {
                    case "z":
                    case "Z":
                    case "atacar":  //jogador decide atacar o monstro
                        int dano = player.atacar(monster);
                        break;
                    case "x":
                    case "X":
                    case "skill":  // caso o jogador escolha usar uma habilidade
                        for (int i = 1; i < 3; i++) {
                            System.out.printf("%d- %s\n", i, player.getSkills().get(i).getNome());
                        }
                        acao = scanner.nextLine();
                        if (acao.equals("1") || acao.equals("2") || acao.equals("3")) { // caso o usuário escolha a habilidade que deseja utilizar corretamente
                            int opcao = Integer.parseInt(acao);
                            System.out.println(player.getSkills().get(opcao).getNome());
                            System.out.println(player.getSkills().get(opcao).getDescricao());
                            System.out.printf("Custo de mana: %d\n", player.getSkills().get(opcao).getCustoMana());
                            System.out.println("Você deseja utilizar esta habilidade? Y-sim N-não");
                            acao = scanner.nextLine();
                            if (acao.equals("y") || acao.equals("Y")) {
                                //jogador confirma o uso da habilidade.
                                int danoskill = player.usarSkill(player.getSkills().get(opcao), monster);
                                if (danoskill == -1) {
                                    //jogador tenta usar a habilidade sem ter mana suficiente.
                                    System.out.println("Você não tem mana suficiente para usar esta habilidade.");
                                    continue;
                                }
                            } else {
                                //O programa volta ao início se o usuário cancelar ou der uma opção inválida,
                                //mas no segundo caso imprime na tela que a opção digitada foi inválida.
                                if (!(acao.equals("n") || acao.equals("N"))) {
                                    System.out.println("Opção inválida.");
                                }
                                continue;
                            }
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                        break;
                    case "c":
                    case "C":
                    case "pocao":
                        System.out.println(Pocao.getDescricao());
                        System.out.print("Deseja utilizar uma poção? Y-Sim N-Não");
                        acao = scanner.nextLine();
                        if (acao.equals("y") || acao.equals("Y")) {
                            //jogador confirma o uso da poção.
                            if (player.usaPocao() == -1) {
                                //jogador tenta usar poção sem ter uma.
                                System.out.println("Você não tem mais poções.");
                                continue;
                            } else System.out.println("Poção usada.");
                        } else {
                            //O programa volta ao início se o usuário cancelar ou der uma opção inválida,
                            //mas no segundo caso imprime na tela que a opção digitada foi inválida.
                            if (!(acao.equals("n") || acao.equals("N"))) {
                                System.out.println("Opção inválida.");
                            }
                            continue;
                        }
                        break;
                    case "v":
                    case "V":
                    case "fugir":
                        if (player.fugir(monster) == 1) {
                            System.out.print("Você fugiu.");
                            return 0;
                        } else System.out.println("Você não conseguiu fugir.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }
            }
            else System.out.println("Você não consegue se mover.");

            if(!monster.getStatus().equals("Atordoado"))
                monster.decidirAtaque(player);
            else System.out.printf("%s não consegue se mover.\n",monster.getNome());
            
            player.passaTurno();
            monster.passaTurno();
            if(player.getVida() <= 0)
            {
                System.out.println(player.getNome() + "morreu.");
                return -1;
            }
            if(monster.getVida() <= 0)
            {
                System.out.println(monster.getNome() + "morreu.");
                int lootChance = Randomizer.randomInt(1,100);
                if(lootChance <= 20)
                {
                    player.addPocao();
                    System.out.printf("Você encontro uma poção. Agora possui %d\n", player.getPocoes());
                }
                return 1;
            }
        }
    }

    public static void printarStatus(Player player, Monstro monster)
    {
        System.out.printf("%s - Hp: %d      Mana = %d\n",player.getNome(),player.getVida(),player.getMana());
        System.out.printf("Status: %s          Turnos Restantes: %d\n", player.getStatus(), player.getTurnoRestanteStatus());
        System.out.println("\n\n");
        System.out.printf("%s - Hp: %d      Mana = %d\n",monster.getNome(),monster.getVida(),monster.getMana());
        System.out.printf("Status: %s          Turnos Restantes: %d\n", monster.getStatus(), monster.getTurnoRestanteStatus());
    }

}
