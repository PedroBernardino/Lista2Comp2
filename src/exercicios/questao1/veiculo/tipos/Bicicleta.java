package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;

public class Bicicleta extends Veiculo implements Terrestre, Offroad {
    public static final String nome = "Bicicleta";
    public void andarNaEstrada() { }
    public void andarForaDaEstrada() { }
    public Bicicleta()
    {
        super(nome);
        geraPeso(10,30);
        geraVelocidade(50,60);
        passageiros = 1;

    }
    
}
