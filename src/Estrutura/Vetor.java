package Estrutura;

public class Vetor {
    private int[] dados;
    private int tamanhoAtual;

    public Vetor(int capacidade) {
        this.dados = new int[capacidade];
        this.tamanhoAtual = 0;
    }

    public void adicionar(int valor) {
        if (tamanhoAtual < dados.length) {
            dados[tamanhoAtual] = valor;
            tamanhoAtual++;
        }
    }

    public int buscaSequencial(int chave) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (dados[i] == chave) return i;
        }
        return -1;
    }

    public int buscaBinaria(int chave) {
        int inicio = 0;
        int fim = tamanhoAtual - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (dados[meio] == chave) return meio;
            if (chave < dados[meio]) fim = meio - 1;
            else inicio = meio + 1;
        }
        return -1;
    }

    public void bubbleSort() {
        for (int i = 0; i < tamanhoAtual - 1; i++) {
            for (int j = 0; j < tamanhoAtual - 1 - i; j++) {
                if (dados[j] > dados[j + 1]) {
                    int temp = dados[j];
                    dados[j] = dados[j + 1];
                    dados[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort() {
        quickSortRecursivo(0, tamanhoAtual - 1);
    }

    private void quickSortRecursivo(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSortRecursivo(inicio, indicePivo - 1);
            quickSortRecursivo(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int pivo = dados[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (dados[j] <= pivo) {
                i++;
                int temp = dados[i];
                dados[i] = dados[j];
                dados[j] = temp;
            }
        }
        int temp = dados[i + 1];
        dados[i + 1] = dados[fim];
        dados[fim] = temp;
        return i + 1;
    }
    
    public int get(int index) { return dados[index]; }
    public int getTamanho() { return tamanhoAtual; }
}