package principal;

import java.util.Random;

import Estrutura.ArvoreAvl;
import Estrutura.ArvoreBinaria;
import Estrutura.Vetor;

public class Main{

    public static int[] gerarOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    public static int[] gerarInverso(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            vetor[i] = tamanho - i - 1;
        }
        return vetor;
    }

    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000};
        String[] ordens = {"Ordenada", "Inversa", "Aleatória"};
        
        for (int tamanho : tamanhos) {
            System.out.println("\n=== Tamanho: " + tamanho + " ===");
            
            for (String ordem : ordens) {
                System.out.println("\n--- Ordem: " + ordem + " ---");
                long tempoTotalInsercaoVetor = 0;
                long tempoTotalInsercaoABB = 0;
                long tempoTotalInsercaoAVL = 0;
                
                for (int i = 0; i < 5; i++) {
                    int[] dados = switch (ordem) {
                        case "Ordenada" -> gerarOrdenado(tamanho);
                        case "Inversa" -> gerarInverso(tamanho);
                        default -> gerarAleatorio(tamanho);
                    };

                    Vetor vetor = new Vetor(tamanho);
                    long inicio = System.nanoTime();
                    for (int v : dados) vetor.adicionar(v);
                    long fim = System.nanoTime();
                    tempoTotalInsercaoVetor += (fim - inicio);

                    ArvoreBinaria abb = new ArvoreBinaria();
                    inicio = System.nanoTime();
                    for (int v : dados) abb.inserir(v);
                    fim = System.nanoTime();
                    tempoTotalInsercaoABB += (fim - inicio);

                    ArvoreAvl avl = new ArvoreAvl();
                    inicio = System.nanoTime();
                    for (int v : dados) avl.inserir(v);
                    fim = System.nanoTime();
                    tempoTotalInsercaoAVL += (fim - inicio);
                }

                System.out.println("Média Inserção Vetor: " + (tempoTotalInsercaoVetor / 5) + " ns");
                System.out.println("Média Inserção ABB: " + (tempoTotalInsercaoABB / 5) + " ns");
                System.out.println("Média Inserção AVL: " + (tempoTotalInsercaoAVL / 5) + " ns");
            }
        }
    }
}
