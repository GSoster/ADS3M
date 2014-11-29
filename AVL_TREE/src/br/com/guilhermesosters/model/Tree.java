package br.com.guilhermesosters.model;

import java.util.ArrayDeque;
import java.util.Stack;

public class Tree {

	private Node root;

	/**
	 * Construtor ja recebendo um nodo raiz.
	 * 
	 * @param root
	 */
	public Tree(Node root) {
		this.root = root;
	}

	public Tree() {

	}

	/**
	 * metodo responsavel por inserir novos nodos na arvore
	 * 
	 * @param newNode
	 */
	public void insert(Node newNode) {
		if (this.root == null)
			this.root = newNode;
		else
			this.root = this.root.insert(newNode);				
	}

	public void print() {
		if (root != null)
			this.root.print();
		else
			System.out.println("arvore vazia");
	}

	/**
	 * Retorna a raiz da arvore
	 * 
	 * @return
	 */
	public Node getRoot() {
		return this.root;
	}
	
	public void posOrderAdjustment(){
		this.root.posOrderAdjustment();
	}

}
