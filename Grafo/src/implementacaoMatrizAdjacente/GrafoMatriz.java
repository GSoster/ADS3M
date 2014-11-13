package implementacaoMatrizAdjacente;

/**
 * Grafo com Implementacao de Matriz Adjacente
 * @author GSoster
 *
 */

public class GrafoMatriz {

	private int grafo[][];
	private int qtdVertices;
	
	public GrafoMatriz(int qtdVertices){
		this.qtdVertices = qtdVertices;
		this.grafo = new int[qtdVertices][qtdVertices];
	}
	
	/**
	 * Adiciona uma aresta a determinados vertices
	 * @param verticeLinha : int --> linha em que sera inserido o peso e criada a aresta (iniciando do 1)
	 * @param verticeColuna : int --> coluna em que sera inserido o peso e criada a aresta (iniciando do 1)
	 */
	public void addAresta(int verticeLinha, int verticeColuna, int peso){
		this.grafo[verticeLinha-1][verticeColuna-1] = peso;
	}
	
	/**
	 * Imprime uma representacao do grafo em formato de matriz
	 */
	public void print(){		
		for(int i = 0; i < this.qtdVertices; i++){
			for(int j = 0; j < this.qtdVertices; j++){
				System.out.print(this.grafo[i][j]+"|");			
			}
			System.out.println();
		}
	}
	
	public void checarArestas(){
		for(int i = 0; i < this.qtdVertices; i++){
			for(int j = 0; j < this.qtdVertices; j++){
				if(this.grafo[i][j] != 0)
					System.out.println("Aresta entre "+i+"[linha] e "+j+ "[coluna] tem peso: "+this.grafo[i][j]);
			}
		}
	}
}
