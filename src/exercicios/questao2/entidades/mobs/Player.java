package exercicios.questao2.entidades.mobs;

import exercicios.auxiliar.Randomizer;
import exercicios.questao2.Entidade;
import exercicios.questao2.entidades.Item;
import exercicios.questao2.entidades.Mob;
import exercicios.questao2.entidades.Parede;
import exercicios.questao2.entidades.itens.Pocao;
import exercicios.questao2.eventos.Batalha;
import exercicios.questao2.eventos.EncontraItem;

import java.util.List;
import java.util.Objects;


public class Player extends Mob {
    private final List<Skill> skills;
    private int pocoes;

    public Player(List <Skill> skills) {
        super();
        this.skills = skills;
        this.ataque = Randomizer.randomInt(15, 20);
        this.vida = 100 - ataque;
        this.mana = 50;
        this.pocoes = 0;
        vidaMax = vida;
        manaMax = mana;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPocoes() {
        return pocoes;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int checaMovimento(String direcao) {
        switch (direcao) {
            case "cima" -> {
                if (!(checaCasaOcupada(this.linha - 1, this.coluna))) {
                    this.mover(linha - 1, coluna);
                    return 1;
                } else {
                    Entidade alvo = tabuleiro[linha - 1][coluna];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha - 1, coluna);
                        return 1;
                    } else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha - 1, coluna);
                        }
                        else if (resultadoBatalha == -1)
                            return -2;
                        return 1;
                    }
                }

            }
            case "esquerda" -> {
                if (!(checaCasaOcupada(this.linha, this.coluna - 1))) {
                    this.mover(linha, coluna - 1);
                    return 1;
                } else {
                    Entidade alvo = tabuleiro[linha][coluna - 1];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha, coluna - 1);
                        return 1;
                    }
                    else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha, coluna - 1);
                        }
                        else if(resultadoBatalha == -1)
                            return resultadoBatalha;
                        return 1;
                    }
                }
            }
            case "direita" -> {
                if (!(checaCasaOcupada(this.linha, this.coluna + 1))) {
                    this.mover(linha, coluna + 1);
                    return 1;
                }
                else {
                    Entidade alvo = tabuleiro[linha][coluna + 1];
                    if (alvo instanceof Parede)
                        return 0;
                    else if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha, coluna + 1);
                        return 1;
                    } else {
                        int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                        if (resultadoBatalha == 1) {
                            this.mover(linha, coluna + 1);
                        }
                        else if(resultadoBatalha == -1)
                            return resultadoBatalha;
                        return 1;
                    }
                }
            }
            case "baixo" -> {
                if (!(checaCasaOcupada(this.linha + 1, this.coluna))) {
                    this.mover(linha + 1, coluna);
                } else {
                    Entidade alvo = tabuleiro[linha + 1][coluna];
                    if (alvo instanceof Parede)
                        return 0;

                    if (alvo instanceof Item) {
                        EncontraItem.pegarItem(this, (Item) alvo);
                        this.mover(linha + 1, coluna);
                        return 1;

                    }
                    int resultadoBatalha = Batalha.lutar(this, (Monstro) alvo);
                    if (resultadoBatalha == 1)
                        this.mover(linha + 1, coluna);
                    else if (resultadoBatalha == -1)
                        return resultadoBatalha;
                }
                return 1;
            }
        }
        return 0;
    }

    public int fugir(Monstro inimigo)
    {
        int chanceFuga = Randomizer.randomInt(1,100);
        if(chanceFuga <= 70 || Objects.equals(inimigo.getStatus(), "Atordoado"))
        {
            return 1;
        }
        else return -1;
    }


    public void aumentaAtaque(int aumento)
    {
        this.ataque += aumento;
    }

    public void aumentaVida(int aumento)
    {
        this.vida += aumento;
        this.vidaMax += aumento;
    }
    public void addPocao()
    {
        this.pocoes++;
    }

    public int usaPocao()
    {
        if(this.pocoes == 0)
            return -1;
        this.curar(Pocao.getCuraVida());
        this.restaurarMana(Pocao.getCuraMana());
        this.pocoes --;
        return 1;
    }
}
