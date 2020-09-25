package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Aquatico;

public class Canoa extends Veiculo implements Aquatico {
    public static final String nome = "Canoa";
    public void andarNaAgua() {}
    public Canoa()
    {
        super(nome);
        geraPeso(100,120);
        geraVelocidade(40,60);
        passageiros = 2;
    }
}
