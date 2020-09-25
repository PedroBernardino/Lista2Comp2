package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Terrestre;

public class Caminhao extends Veiculo implements Terrestre, InteriorImpermeavel {
    public static final String nome = "Caminhao";
    public void andarNaEstrada() {}
    public void andarNaChuva() {}
    public Caminhao()
    {
        geraPeso(920,1000);
        geraVelocidade(90,110);
        passageiros = 3;
    }
}
