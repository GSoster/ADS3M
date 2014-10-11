package br.com.guilhermesoster.model;

public class Tree {

	private Node root;

	/**
	 * metodo responsavel por inserir novos nodos na arvore
	 * 
	 * @param newNode
	 */
	public void insert(Node newNode) {
		if (this.root == null)
			this.root = newNode;
		else
			this.root.insert(newNode);

	}

	/**
	 * realiza a busca em toda a arvore
	 */
	public void preOrderSearch() {
		this.root.preOrderSearch();
	}

	/**
	 * realiza a busca 'em ordem' em toda a arvore:
	 * filho da esquerda, this, filho da direita 
	 */
	public void inOrderSearch(){
		this.root.inOrderSearch();
	}
	
	public void print(){
		this.root.print();
	}
}
