package exercicios.questao1.veiculo.tipos;

import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.interfaces.Anfibio;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;

public class TanqueAnfibio extends Veiculo implements Anfibio, Offroad, InteriorImpermeavel {
    public static final String nome = "Tanque Anfíbio";
    public void andarNaEstrada() {}
    public void andarNaAgua() {}
    public void andarForaDaEstrada() {}
    public void andarNaChuva() {}
    public TanqueAnfibio()
    {
        super(nome);
        geraPeso(300,350);
        geraVelocidade(80,100);
        passageiros = 2;
    }
}
