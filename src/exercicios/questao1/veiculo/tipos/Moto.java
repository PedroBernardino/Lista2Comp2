package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Terrestre;

public class Moto extends Veiculo implements Terrestre {
    public static final String nome = "Moto";
    public void andarNaEstrada() { }
    public Moto()
    {
        geraPeso(50,70);
        geraVelocidade(130,150);
        passageiros = 2;
    }
}
