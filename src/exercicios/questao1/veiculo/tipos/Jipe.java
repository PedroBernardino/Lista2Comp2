package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;

public class Jipe extends Veiculo implements Terrestre, Offroad, InteriorImpermeavel {
    public static final String nome = "Jipe";
    public void andarNaEstrada() {}
    public void andarForaDaEstrada() {}
    public void andarNaChuva() {}
    public Jipe()
    {
        geraPeso(140,160);
        geraVelocidade(170,190);
        passageiros = 4;
    }
}
