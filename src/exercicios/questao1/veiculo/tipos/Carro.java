package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Terrestre;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;


public class Carro extends Veiculo implements Terrestre, InteriorImpermeavel {
    public static final String nome = "Carro";
    public void andarNaEstrada() {}

    public void andarNaChuva() { }

    public Carro()
    {
        super(nome);
        geraPeso(180,200);
        geraVelocidade(220,250);
        passageiros = 5;
    }

}
