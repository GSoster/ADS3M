package Main;

import implementacaoMatrizAdjacente.GrafoMatriz;

public class Main {

	
	public static void main(String[] args){
		
		GrafoMatriz grafoMatriz = new GrafoMatriz(3);
		grafoMatriz.addAresta(2, 1, 10);//adiciona uma aresta de peso 10 a linha 2 coluna 1
		grafoMatriz.print();
		grafoMatriz.checarArestas();
		
	}
}
