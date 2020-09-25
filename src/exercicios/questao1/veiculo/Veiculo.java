package exercicios.questao1.veiculo;

import exercicios.auxiliar.Randomizer;
import exercicios.questao1.veiculo.interfaces.Aquatico;
import exercicios.questao1.veiculo.interfaces.InteriorImpermeavel;
import exercicios.questao1.veiculo.interfaces.Offroad;
import exercicios.questao1.veiculo.interfaces.Terrestre;

public abstract class Veiculo {
    protected static String nome;
    protected double velocidadeMax;
    protected double pesoMax;
    protected static int passageiros;

    public double getVelocidadeMax()
    {
        return this.velocidadeMax;
    }

    public double getPesoMax()
    {
        return this.pesoMax;
    }

    public static int getPassageiros() {
        return passageiros;
    }

    public static String getNome() {
        return nome;
    }

    protected double calculaTempoViagem(double distancia)
    {
        double velocidadeMedia = this.velocidadeMax/2;
        return distancia / velocidadeMedia;
    }


    public boolean verifica(double distancia, String tipoCaminho, int numPessoas, double pesoCarga, double tempoLimite, String clima)
    {
        if (this.calculaTempoViagem(distancia) > tempoLimite) {
            System.out.println("Falhou no tempo");
            return false;
        }
        if (tipoCaminho.equals("rodovia") && !(this instanceof Terrestre)) {
            System.out.println("Falhou no terreno");
            return false;
        }
        if(tipoCaminho.equals("estrada de terra") && !(this instanceof Offroad)) {
            System.out.println("Falhou no terreno");
            return false;
        }
        if((tipoCaminho.equals("rio") || tipoCaminho.equals("lago") || tipoCaminho.equals("mar")) && !(this instanceof Aquatico)) {
            System.out.println("Falhou no terreno");
            return false;
        }
        if (numPessoas > this.passageiros) {
            System.out.println("Falhou no num de passageiros");
            return false;
        }
        if(pesoCarga > this.pesoMax) {
            System.out.println("Falhou no peso");
            return false;
        }
        if(clima.equals("chuva") && !(this instanceof InteriorImpermeavel)) {
            System.out.println("Falhou no clima");
            return false;
        }
        return true;
    }

    protected void geraVelocidade(double min, double max)
    {
        this.velocidadeMax = Randomizer.randomDouble(min,max);
    }
    protected void geraPeso(double min,double max)
    {
        this.pesoMax = Randomizer.randomDouble(min,max);
    }
}
