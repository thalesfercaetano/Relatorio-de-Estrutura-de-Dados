package principal;

import java.util.Random;
import Estrutura.ArvoreAvl;
import Estrutura.ArvoreBinaria;
import Estrutura.Vetor;

public class MotorTeste {

    public static void executarTeste(int tamanho) {
        System.out.println("\n=== Tamanho: " + tamanho + " ===");
        String[] ordens = {"Ordenada", "Inversa", "Aleatória"};
        Random random = new Random();

        for (String ordem : ordens) {
            System.out.println("\n--- Ordem: " + ordem + " ---");
            
            long tempoInsVetor = 0, tempoInsABB = 0, tempoInsAVL = 0;
            long tempoBuscaVetor = 0, tempoBuscaABB = 0, tempoBuscaAVL = 0;
            long tempoBubble = 0;
            long tempoQuick = 0;

            for (int i = 0; i < 5; i++) {
                int[] dados = switch (ordem) {
                    case "Ordenada" -> GeradorDados.gerarOrdenado(tamanho);
                    case "Inversa" -> GeradorDados.gerarInverso(tamanho);
                    default -> GeradorDados.gerarAleatorio(tamanho);
                };

                Vetor vetor = new Vetor(tamanho);
                ArvoreBinaria abb = new ArvoreBinaria();
                ArvoreAvl avl = new ArvoreAvl();

                long inicio = System.nanoTime();
                for (int v : dados) vetor.adicionar(v);
                tempoInsVetor += (System.nanoTime() - inicio);

                inicio = System.nanoTime();
                for (int v : dados) abb.inserir(v);
                tempoInsABB += (System.nanoTime() - inicio);

                inicio = System.nanoTime();
                for (int v : dados) avl.inserir(v);
                tempoInsAVL += (System.nanoTime() - inicio);
                
                int[] alvos = {
                    dados[0], 
                    dados[tamanho - 1], 
                    dados[tamanho / 2], 
                    dados[random.nextInt(tamanho)], 
                    dados[random.nextInt(tamanho)], 
                    dados[random.nextInt(tamanho)], 
                    -1
                };

                for (int alvo : alvos) {
                    inicio = System.nanoTime(); vetor.buscaSequencial(alvo); tempoBuscaVetor += (System.nanoTime() - inicio);
                    inicio = System.nanoTime(); abb.buscar(alvo); tempoBuscaABB += (System.nanoTime() - inicio);
                    inicio = System.nanoTime(); avl.buscar(alvo); tempoBuscaAVL += (System.nanoTime() - inicio);
                }

                Vetor vQuick = new Vetor(tamanho);
                for(int v : dados) vQuick.adicionar(v);
                inicio = System.nanoTime();
                vQuick.quickSort();
                tempoQuick += (System.nanoTime() - inicio);

                Vetor vBubble = new Vetor(tamanho);
                for(int v : dados) vBubble.adicionar(v);
                inicio = System.nanoTime();
                vBubble.bubbleSort();
                tempoBubble += (System.nanoTime() - inicio);
            }

            System.out.println("Inserção Média (ns) -> Vetor: " + (tempoInsVetor/5) + " | ABB: " + (tempoInsABB/5) + " | AVL: " + (tempoInsAVL/5));
            System.out.println("Busca Média (ns)    -> Vetor: " + (tempoBuscaVetor/35) + " | ABB: " + (tempoBuscaABB/35) + " | AVL: " + (tempoBuscaAVL/35));
            System.out.println("Ordenação Média (ns)-> Bubble: " + (tempoBubble/5) + " | Quick: " + (tempoQuick/5));
        }
    }
}