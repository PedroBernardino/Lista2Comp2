package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Aquatico;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;

public class Lancha extends Veiculo implements Aquatico, InteriorImpermeavel {
    public static final String nome = "Lancha";
    public void andarNaAgua() {}
    public void andarNaChuva() {}
    public Lancha()
    {
        geraPeso(200,230);
        geraVelocidade(140,160);
        passageiros = 4;
    }
}
