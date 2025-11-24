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
    
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    } 
    
    public void inserir(int valor){
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No node, int valor){
        
        if(node == null){
            return(new No(valor));
        }
        if(valor < node.valor){
            node.esquerda = inserirRecursivo(node.esquerda, valor);
        } else if (valor > node.valor){
            node.direita = inserirRecursivo(node.direita, valor);
        } else {
            return node;
        }

        node.altura = 1 + max(altura(node.esquerda), altura(node.direita));

        int balanceamento = getBalanceamento(node);

        if(balanceamento > 1 && valor < node.esquerda.valor){
            return rotacaoDireita(node);
        }
        if(balanceamento < -1 && valor > node.direita.valor){
            return rotacaoEsquerda(node);
        }
        if(balanceamento > 1 && valor > node.esquerda.valor){
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }
        if(balanceamento < -1 && valor < node.direita.valor){
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;

    }
}