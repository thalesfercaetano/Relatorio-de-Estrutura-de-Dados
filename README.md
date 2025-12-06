# Análise de Desempenho de Estruturas de Dados em Java

## Sobre o Projeto
Este projeto foi desenvolvido para a disciplina de Estrutura de Dados. O objetivo é comparar o desempenho (tempo de execução) entre:
1. **Vetor** (Busca Sequencial, Bubble Sort, Quick Sort)
2. **Árvore Binária de Busca (ABB)**
3. **Árvore AVL** (Auto-balanceada)

As métricas incluem tempo de inserção, busca e ordenação para conjuntos de dados de 100, 1.000 e 10.000 elementos (Ordenados, Inversos e Aleatórios).

## Estrutura do Projeto
- `src/Estrutura`: Contém as classes das estruturas de dados (`Vetor`, `ArvoreBinaria`, `ArvoreAvl`).
- `src/principal`: Contém a classe `Main` responsável pela execução dos testes automatizados.

## Como Compilar e Executar
Certifique-se de ter o Java (JDK) instalado. No terminal, na raiz do projeto:

1. Compilar o código:
   ```bash
   javac -d bin src/Estrutura/*.java src/principal/Main.java