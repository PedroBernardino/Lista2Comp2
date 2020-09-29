package exercicios.questao2.eventos;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.DungeonExplorer;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.entidades.mobs.Monstro;
import exercicios.questao2.entidades.mobs.Player;

import java.util.Objects;
import java.util.Scanner;


/** Classe abstrata Batalha, que representa uma Batalha entre o jogador e um monstro.
 * <p>
 * Classe figurativa que envolve a abstratificação de uma Batalha, simulando uma batalha de turnos entre o herói e um
 * dos monstros do mapa após um encontro entre ambos.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.2
 * @since       1.0
 */
public abstract class Batalha {

    /**
     * Simula a luta entre um jogador e um monstro.
     * <p>
     * Esse método é acionado quando um jogador entra numa casa com um monstro, e implementa uma série de turnos
     * de ações do player e do monstro até que a batalha chegue a um dos 3 possíveis resultados.
     * O método retorna 1 caso o player mate o monstro, 0 caso o player fuja da batalha e -1 caso o player acabe morto
     * no combate.
     * </p>
     *
     * @param player o jogador que participará da batalha.
     * @param monster o monstro que participará da batalha
     *
     * @return 1 caso o monstro morra, 0 caso o player fuja e -1 caso o player morra
     */
    public static int lutar(Player player, Monstro monster)
    {
        System.out.println("Você encontrou um monstro! A batalha se inicia");
        int checkMortes;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Batalha.printarStatus(player, monster);
            if(!Objects.equals(player.getStatus(), "Atordoado")) { //verifica se o jogador não está atordoado

                String acao = scanner.nextLine(); // le a próxima ação do jogador


                switch (acao) {
//jogador decide atacar o monstro
                    case "z", "Z", "atacar" -> {
                        System.out.println("Você ataca o monstro causando 100% do seu ataque.");
                        System.out.println("Deseja atacar o monstro? Y-sim N-não");
                        if (DungeonExplorer.confirm(scanner))
                            player.atacar(monster);
                        else continue;
                    }
// caso o jogador escolha usar uma habilidade
                    case "x", "X", "skill" -> {
                        for (int i = 0; i <= 2; i++) {
                            System.out.printf("%d- %s\n", i+1, player.getSkills().get(i).getNome());
                        }
                        acao = scanner.nextLine();
                        if (acao.equals("1") || acao.equals("2") || acao.equals("3")) { // caso o usuário escolha a habilidade que deseja utilizar corretamente
                            int opcao = Integer.parseInt(acao)-1;
                            System.out.println(player.getSkills().get(opcao).getNome());
                            System.out.println(player.getSkills().get(opcao).getDescricao());
                            System.out.printf("Custo de mana: %d\n", player.getSkills().get(opcao).getCustoMana());
                            System.out.println("Você deseja utilizar esta habilidade? Y-sim N-não");
                            if (DungeonExplorer.confirm(scanner)) {
                                //jogador confirma o uso da habilidade.
                                int danoskill = player.usarSkill(player.getSkills().get(opcao), monster);
                                if (danoskill == -1) {
                                    //jogador tenta usar a habilidade sem ter mana suficiente.
                                    System.out.println("Você não tem mana suficiente para usar esta habilidade.");
                                    continue;
                                }
                            } else continue;
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                    }
                    case "c", "C", "pocao", "Pocao" -> {
                        System.out.println(Pocao.getDescricao());
                        System.out.println("Deseja utilizar uma poção? Y-Sim N-Não");
                        if (DungeonExplorer.confirm(scanner)) {
                            //jogador confirma o uso da poção.
                            if (player.usaPocao() == -1) {
                                //jogador tenta usar poção sem ter uma.
                                System.out.println("Você não tem mais poções.");
                                continue;
                            } else System.out.println("Poção usada.");
                        } else continue;
                    }
                    case "v", "V", "fugir" -> {
                        System.out.println("Suas chances de fugir são de 70% , ou 100% caso seu oponente esteja atordoado.");
                        System.out.println("Deseja fugir? Y-Sim N-Não");
                        if (DungeonExplorer.confirm(scanner)) {
                            if (player.fugir(monster) == 1) {
                                System.out.print("Você fugiu.");
                                return 0;
                            } else System.out.println("Você não conseguiu fugir.");
                        } else continue;
                    }
                    default -> {
                        System.out.println("Opção inválida.");
                        continue;
                    }
                }
            }
            else System.out.println("Você não consegue se mover.");

            System.out.println();

            checkMortes = checaMorte(player,monster);
            if(checkMortes != 0)
            {
                return checkMortes;
            }

            if(!Objects.equals(monster.getStatus(), "Atordoado"))
                monster.decidirAtaque(player);
            else System.out.println(monster.getNome() +" não consegue se mover.");

            checkMortes = checaMorte(player,monster);
            if(checkMortes != 0)
                return  checkMortes;
            
            player.passaTurno();
            monster.passaTurno();

            checkMortes = checaMorte(player,monster);
            if(checkMortes != 0)
                return  checkMortes;
        }
    }

    /**
     * Mostra pro usuário o status atual do seu jogador e do monstro que está batalhando
     * <p>
     * Esse método é chamado a cada começo de turno, mostrando ao usuário a situação atual da batalha (vida, mana, ataque
     * e status dos combatentes) para que o jogador decida sua próxima ação
     * </p>
     *
     * @param player o jogador que está na batalha
     * @param monster o monstro que está na batalha
     */
    private static void printarStatus(Player player, Monstro monster)
    {
        System.out.println("----------------------------------------------");
        System.out.printf("%s - Ataque : %d     Hp: %d      Mana = %d\n", player.getNome(),player.getAtaque(),player.getVida(),player.getMana());
        System.out.println("Poções restantes: "+ player.getPocoes());
        if(player.getStatus() != null)
            System.out.printf("Status: %s          Turnos Restantes: %d\n", player.getStatus(), player.getTurnoRestanteStatus());
        else System.out.println("Status: Nenhum");
        System.out.println("\n\n");
        System.out.printf("%s - Ataque : %d     Hp: %d      Mana = %d\n",monster.getNome(),monster.getAtaque(), monster.getVida(),monster.getMana());
        if(monster.getStatus() == null )
            System.out.println("Status: Nenhum");
        else if (monster.getStatus().equals("Imune"))
            System.out.println("Status: Imune         Turnos Restantes: Infinito\n");
        else System.out.printf("Status: %s          Turnos Restantes: %d\n", monster.getStatus(), monster.getTurnoRestanteStatus());
        System.out.println("----------------------------------------------");
        System.out.println("Z-atacar  X-Usar Skill  C-Poção  V-Fugir");
    }

    /**
     * Checa se um dos combatentes morreu
     * <p>
     * Esse método é chamado toda vez em que um dos combatentes possa ter recebido dano (após as ações de ambos e no fim
     * do turno). Printa na tela caso um dos combatentes morra.
     * Retorna 1 caso o jogador tenha vencido o monstro, e chama o método que dropa um loot ao player.
     * Retorna 0 caso ninguém tenha morrido até o momento.
     * Retorna -1 caso o player tenha morrido.
     * </p>
     *
     * @param player o jogador que está na batalha
     * @param monster o monstro que está na batalha
     *
     * @return 1 caso o monstro morra, 0 caso ninguem tenha morrido e -1 caso o jogador morra.
     */
    private static int checaMorte(Player player, Monstro monster)
    {
        //se o jogador morreu
        if(player.getVida() <= 0)
        {
            System.out.println(player.getNome() + " morreu.");
            return -1;
        }

        //se o monstro morreu
        else if(monster.getVida() <= 0)
        {
            System.out.println(monster.getNome() + " morreu.");
            Monstro.numerodeMonstros --;
            droparLootMonstro(player);
            return 1;
        }
        else return 0;
    }

    /**
     * Tem 10% de chance de dropar uma poção ao usuário.
     * <p>
     * Esse método é ativado após um monstro morrer em uma batalha. Gera um número aleatório, com 10% de chance de dar
     * ao player uma poção a mais após o fim da batalha.
     * </p>
     *
     * @param player o jogador que derrotou o monstro e poderá receber a poção.
     */
    private static void droparLootMonstro(Player player)
    {
        int lootChance = Randomizer.randomInt(1,100);
        if(lootChance <= 20)
        {
            player.addPocao();
            System.out.printf("Você encontro uma poção. Agora possui %d\n", player.getPocoes());
        }
    }
}
