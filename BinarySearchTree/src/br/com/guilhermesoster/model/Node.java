package br.com.guilhermesoster.model;

public class Node {

	private int value;
	private Node[] children;
	private Node parent;
	private int h;//altura
	private int fb;//fator de balanceamento

	public Node(int value) {
		this.value = value;
		children = new Node[2];
	}

	public Node(int value, Node parent) {
		this.value = value;
		children = new Node[2];
		this.parent = parent;
		this.h = 0;
	}

	/**
	 * Insere um filho de forma ordenada: esquerda -> menor que o nodo
	 * pai(this); direita -> maior que o nodo pai(this)
	 * 
	 * @param newChildren
	 */
	public void insert(Node newChildren) {
		if (newChildren != null) {
			if (newChildren.getValue() < this.getValue()) {// inser��o na
															// esquerda
				if (this.getLeftChild() == null) {
					this.setLeftChild(newChildren);
					this.getLeftChild().setParent(this);
				} else
					this.getLeftChild().insert(newChildren);
			} else {// inser��o na direita
				if (this.getRightChild() == null) {
					this.setRightChild(newChildren);
					this.getRightChild().setParent(this);
				} else
					this.getRightChild().insert(newChildren);
			}

		}
	}

	/**
	 * faz uma busca em toda a arvore da seguinte forma: filho da esquerda,
	 * this, filho da direita
	 */
	public void inOrderSearch() {
		if (this.getLeftChild() != null)
			this.getLeftChild().inOrderSearch();
		System.out.print(this.getValue());
		if (this.getRightChild() != null)
			this.getRightChild().inOrderSearch();
	}

	/**
	 * faz uma busca em toda a arvore da seguinte forma: this, filho da
	 * esquerda, filho da direita
	 */
	public void preOrderSearch() {
		System.out.print(this.getValue());
		if (this.getLeftChild() != null)
			this.getLeftChild().preOrderSearch();
		if (this.getRightChild() != null)
			this.getRightChild().preOrderSearch();
	}

	/**
	 * Faz a busca em toda a arvore da seguinte forma; filho da esquerda, filho
	 * da direita, this
	 */
	public void posOrderSearch() {
		if (this.getLeftChild() != null)
			this.getLeftChild().posOrderSearch();
		if (this.getRightChild() != null)
			this.getRightChild().posOrderSearch();
		System.out.print(this.getValue());
	}

	/**
	 * Representa��o gr�fica da arvore no seguinte formato:
	 * (root(child(child)(child))(child(child)(child)))
	 */
	public void print() {
		System.out.print("(" + this.getValue());// se imprime
		if (this.getLeftChild() != null)
			this.getLeftChild().print();
		if (this.getRightChild() != null)
			this.getRightChild().print();
		System.out.print(")");
	}

	/**
	 * retorna o valor armazenado no nodo
	 * 
	 * @return value:int
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Busca o filho da esquerda (menor que o nodo pai)
	 * 
	 * @return menor filho:Node
	 */
	public Node getLeftChild() {
		return this.children[0];
	}

	/**
	 * Busca o filho da direita (maior que o nodo pai)
	 * 
	 * @return maior filho:Node
	 */
	public Node getRightChild() {
		return this.children[1];
	}

	/**
	 * insere um filho na posi��o da esquerda em rela��o ao nodo atual
	 * 
	 * @param newChildren
	 */
	public void setLeftChild(Node newChild) {
		this.children[0] = newChild;
	}

	/**
	 * insere um filho na posi��o da direita em rela��o ao nodo atual
	 * 
	 * @param newChildren
	 */
	public void setRightChild(Node newChild) {
		this.children[1] = newChild;
	}

	/**
	 * Adiciona um pai ao nodo.
	 * 
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Retorna o pai do nodo atual
	 * 
	 * @return node:parent
	 */
	public Node getParent() {
		return this.parent;
	}
	
	/**
	 * Calcula a altura (h).
	 * @return
	 */
	public int calcH(){
		this.h = 1 + (Math.max(this.getLeftChild().calcH(), this.getRightChild().calcH()));
		return this.h;
	}
	
	/**
	 * retorna a altura da arvore
	 * @return
	 */
	public int getH(){
		return this.h;
	}
	
	/**
	 * deprecated hehe
	 * @return
	 */
	public int calcFb(){
		this.fb = (this.getLeftChild().calcH() - this.getRightChild().calcH());
		return this.fb;
	}

}
