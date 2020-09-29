package exercicios.questao1;


import exercicios.questao1.veiculo.Veiculo;
import exercicios.questao1.veiculo.tipos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Classe principal do programa, que lista os veículos capazes de cumprir determinada viagem.
 * <p>
 * Classe responsável pela execução do programa Veículos, que verifica, dado uma lista de veículos
 * e o trajeto desejado , quais destes são capazes de realizar a viagem considerando o tempo limite, o tipo de
 * terreno, o clima , a quantidade de carga e o número de passageiros para a viagem.
 * </p>
 * @author      Pedro Bernardino - pedrohbshbs@gmail.com
 * @version     1.3
 * @since       0.5
 */
public class Verificador {

    public static void main(String[] args) {

        String entrada, terreno, clima;
        double distancia, tempo, carga;
        int numpassageiros;
        String[] requisito;
        Scanner scanner = new Scanner(System.in);

        // recebendo os dados de entrada do usuário
        System.out.println("Digite a Lista de requisitos: distancia, terreno, numero de passageiros, peso da carga, tempo limite e clima");
        do
        {
            entrada = scanner.nextLine();
            requisito = entrada.split(",");
            if (requisito.length != 6)
                System.out.println("Número de requisitos inválido, por favor digite todos os requisitos.");
        }while (requisito.length != 6);

        requisito = entrada.split(",");
        distancia = Double.parseDouble(requisito[0].trim());
        terreno = requisito[1].trim();
        numpassageiros = Integer.parseInt(requisito[2].trim());
        carga = Double.parseDouble(requisito[3].trim());
        tempo = Double.parseDouble(requisito[4].trim());
        clima = requisito[5].trim();
        List <Veiculo> lista = new ArrayList<>();

        //criando instâncias dos veículos específicos
        for(int i = 0; i< 3; i ++)
        {
            Carro carro = new Carro();
            Caminhao caminhao = new Caminhao();
            Bicicleta bike = new Bicicleta();
            Moto moto = new Moto();
            Canoa canoa = new Canoa();
            Jipe jipe = new Jipe();
            Lancha lancha = new Lancha();
            TanqueAnfibio tanque = new TanqueAnfibio();

            lista.add(carro);
            lista.add(caminhao);
            lista.add(bike);
            lista.add(moto);
            lista.add(canoa);
            lista.add(jipe);
            lista.add(lancha);
            lista.add(tanque);
        }

        //mostrando ao usuário os veículos que são capazes de realizar a viagem.
        for (Veiculo veiculo:lista) {
            if(veiculo.verifica(distancia,terreno,numpassageiros,carga,tempo,clima)) {
                System.out.printf("%s : vel.máxima = %f km/h, carga max. = %f kg, max. passageiros = %d\n",veiculo.getNomeTipo(), veiculo.getVelocidadeMax(), veiculo.getPesoMax(), veiculo.getPassageiros());
            }
        }
    }
}