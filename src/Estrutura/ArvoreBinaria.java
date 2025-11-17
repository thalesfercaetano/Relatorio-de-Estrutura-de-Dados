package Estrutura;

public class ArvoreBinaria {
    protected No raiz;
    
    private static class No {
        int valor;
        No esquerda;
        No direita;

        No(int valor){
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    public void inserir(int valor){
        raiz = inserirRecursivo(raiz, valor);
    }

    protected No inserirRecursivo(No atual, int valor){
        if(atual == null){
            return new No(valor);
        }
        if(valor < atual.valor){
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        }else if(valor > atual.valor){
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual;
    }

    public boolean buscar(int valor){
        return buscarRecursivo(raiz, valor);
    }

    protected boolean buscarRecursivo(No atual, int valor){        
        if(atual == null){
            return false;
        }
        if(valor == atual.valor){
            return true;
        }
        if(valor < atual.valor){
            return buscarRecursivo(atual.esquerda, valor);
        }
        if(valor > atual.valor){
            return buscarRecursivo(atual.direita, valor);
        }

        return false;
    }
}
