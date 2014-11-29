package br.com.guilhermesosters.model;

public class Node {

	private int value;
	private Node[] children;
	private Node parent;
	private int h;// height
	private int fb; // fator de balanceamento

	public Node(int valor) {
		this.children = new Node[2];
		this.parent = null;
		this.value = valor;
		this.h = 1;
		this.fb = 0;
	}

	public Node(int valor, Node parent) {
		this.children = new Node[2];
		this.parent = parent;
		this.value = valor;
		this.h = 1;
		this.fb = 0;
	}

	public Node insert(Node n) {
		if (n.getValue() < this.value) {
			if (this.getLeftChild() == null) {
				this.setLeftChild(n);
				n.setParent(this);
				n.incrementParentH();
			} else {
				this.getLeftChild().insert(n);
			}
		}
		if (n.getValue() > this.value) {
			if (this.getRightChild() == null) {
				this.setRightChild(n);
				n.setParent(this);
				n.incrementParentH();
			} else {
				this.getRightChild().insert(n);
			}
		}
		return this.correct();
	}

	public void incrementParentH() {
		this.parent.setH(parent.getH() + 1);
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
	 * insere um filho na posição da esquerda em relação ao nodo atual
	 * 
	 * @param newChildren
	 */
	public void setLeftChild(Node newChild) {
		this.children[0] = newChild;
	}

	/**
	 * insere um filho na posição da direita em relação ao nodo atual
	 * 
	 * @param newChildren
	 */
	public void setRightChild(Node newChild) {
		this.children[1] = newChild;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	/**
	 * Representação gráfica da arvore no seguinte formato:
	 * (root(child(child)(child))(child(child)(child)))
	 */
	public void print() {
		System.out.print("(" + this.getValue() + " H->" + this.h + " FB->"
				+ this.fb);// se imprime
		if (this.getLeftChild() != null)
			this.getLeftChild().print();
		if (this.getRightChild() != null)
			this.getRightChild().print();
		System.out.print(")");
	}

	public Node leftRotation() {
		/*
		 * b becomes the new root. a takes ownership of b's left child as its
		 * right child, or in this case, null. b takes ownership of a as its
		 * left child
		 */
		Node newRoot = this.getRightChild();
		Node newLeftChild = this;
		newLeftChild.setRightChild(newRoot.getLeftChild());
		newRoot.setLeftChild(newLeftChild);
		// ajustando parentesco
		newRoot.setParent(newLeftChild.getParent());
		newLeftChild.setParent(newRoot);
		return newRoot;
	}

	/*
	 * public Node leftRotation() { Node fd = getRightChild(); Node b =
	 * getRightChild().getLeftChild(); fd.setLeftChild(this); setParent(fd);
	 * fd.setParent(this.getParent()); setLeftChild(b); return fd; }
	 */

	public Node rightRotation() {
		/*
		 * b becomes the new root. a takes ownership of b's right child, as its
		 * left child. In this case, that value is null. b takes ownership of a,
		 * as it's right child
		 */
		Node newRoot = this.getLeftChild();
		Node newRightChild = this;
		newRightChild.setLeftChild(newRoot.getRightChild());
		newRoot.setRightChild(newRightChild);
		// ajustando parentesco
		newRoot.setParent(newRightChild.getParent());
		newRightChild.setParent(newRoot);
		return newRoot;
	}

	/**
	 * public Node rightRotation() { Node fe = getLeftChild();// filho esquerda
	 * Node b = getLeftChild().getRightChild();// neto direita
	 * fe.setRightChild(this); setParent(fe); fe.setParent(this.getParent());
	 * setRightChild(b); return fe; }
	 **/

	public int calculateH() {
		int hLeftChild = 0;
		int hRightChild = 0;
		if (this.getLeftChild() != null)
			hLeftChild = this.getLeftChild().calculateH();
		if (this.getRightChild() != null)
			hRightChild = this.getRightChild().calculateH();
		if (this.getLeftChild() == null && this.getRightChild() == null)
			return this.h;
		this.h = 1 + Math.max(hLeftChild, hRightChild);
		return this.h;
	}

	public int calculateFb() {
		int hLeftChild = 0;
		int hRightChild = 0;
		if (this.getLeftChild() != null)
			hLeftChild = this.getLeftChild().calculateH();
		if (this.getRightChild() != null)
			hRightChild = this.getRightChild().calculateH();
		this.fb = hLeftChild - hRightChild;
		return this.fb;
	}

	public Node correct() {
		Node r = this;
		if (calculateFb() == -2) {
			if (getRightChild().calculateFb() == +1) {
				setRightChild(getRightChild().rightRotation());
			}
			r = leftRotation();
		}
		if (calculateFb() == +2) {
			if (getLeftChild().calculateFb() == -1) {
				setLeftChild(getLeftChild().leftRotation());
			}
			r = rightRotation();
		}
		// r.posOrdem({calculateH(), calculateFb()});
		return r;
	}

	/**
	 * Faz a busca em toda a arvore da seguinte forma; filho da esquerda, filho
	 * da direita, this
	 */
	public void posOrderSearch(Node n) {
		if (n.getLeftChild() != null)
			n.posOrderSearch(getLeftChild());
		if (n.getRightChild() != null)
			n.posOrderSearch(getRightChild());
		this.calculateH();
		this.calculateFb();
	}

}
