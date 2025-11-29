package principal;

import java.util.Random;

public class Main{

    public static int[] gerarOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    public static int[] gerarAleatorio(int tamanho){
        int[]  vetor = new int[tamanho];
        Random random = new Random();
        for(int i = 0; i < tamanho; i++){
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }

    public static void main(String[] args) {
}
}