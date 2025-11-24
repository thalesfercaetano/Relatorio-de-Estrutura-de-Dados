package Estrutura;

public class ArvoreAvl {
    private No raiz;

    private class No {
        int valor, altura;
        No esquerda, direita;

        No(int d) {
            valor = d;
            altura = 1;
        }
    }

    private int altura(No N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    private int getBalanceamento(No N) {
        if (N == null)
            return 0;
        return altura(N.esquerda) - altura(N.direita);
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null){
            return false;
        }
        if (valor == atual.valor){
            return true;
        }
        return valor < atual.valor ? buscarRecursivo(atual.esquerda, valor) : buscarRecursivo(atual.direita, valor);
    }
}