# Análise de Desempenho de Estruturas de Dados em Java

## Sobre o Projeto
Este projeto foi desenvolvido para a disciplina de Estrutura de Dados. O objetivo é comparar o desempenho (tempo de execução) entre:
1. **Vetor** (Busca Sequencial, Bubble Sort, Quick Sort)
2. **Árvore Binária de Busca (ABB)**
3. **Árvore AVL** (Auto-balanceada)

As métricas incluem tempo de inserção, busca e ordenação para conjuntos de dados de 100, 1.000 e 10.000 elementos (Ordenados, Inversamente Ordenados e Aleatórios).

## Estrutura do Projeto
O código foi refatorado para facilitar a execução de testes pesados de forma modular:

- `src/Estrutura`: Contém as implementações das estruturas de dados (`Vetor`, `ArvoreBinaria`, `ArvoreAvl`).
- `src/principal`: Contém a lógica de testes:
  - [cite_start]`MotorTeste.java`: O "coração" do projeto, contendo a lógica de medição de tempo e execução das baterias de testes[cite: 3].
  - [cite_start]`GeradorDados.java`: Classe utilitária responsável por criar os vetores de dados (ordenados, inversos e aleatórios)[cite: 6].
  - [cite_start]`Teste100.java`, `Teste1000.java`, `Teste10000.java`: Executáveis individuais para cada tamanho de massa de dados[cite: 1, 8, 9].

## Como Compilar e Executar
Certifique-se de ter o Java (JDK) instalado. No terminal, na raiz do projeto:

### 1. Compilar o Código
Como existem novos ficheiros na pasta principal, o comando de compilação foi atualizado:

```bash
javac -d bin src/Estrutura/*.java src/principal/*.java