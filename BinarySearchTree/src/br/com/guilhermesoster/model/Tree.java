package br.com.guilhermesoster.model;

import java.util.ArrayDeque;
import java.util.Stack;

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
	 * realiza a busca 'em ordem' em toda a arvore: filho da esquerda, this,
	 * filho da direita
	 */
	public void inOrderSearch() {
		this.root.inOrderSearch();
	}

	/**
	 * Realiza a busca 'pos ordem' em toda a arvore: filho da esquerda, filho da
	 * direita, this
	 */
	public void posOrderSearch() {
		this.root.posOrderSearch();
	}

	/**
	 * busca em profundidade
	 */
	public void stackSearch() {
		System.out.println("Busca em profundidade:");
		Stack<Node> stack = new Stack<Node>();
		stack.push(this.root);
		while (!stack.empty()) {
			Node lastElement = stack.pop();
			if (lastElement.getLeftChild() != null)
				stack.push(lastElement.getLeftChild());
			if (lastElement.getRightChild() != null)
				stack.push(lastElement.getRightChild());

			System.out.println(lastElement.getValue());

		}
	}

	/**
	 * busca em largura
	 */
	public void deckSearch() {
		System.out.println("largura:");
		ArrayDeque<Node> deck = new ArrayDeque<Node>();
		deck.add(this.root);// adiciona ao fim		
		while (!deck.isEmpty()) {
			Node lastElement = deck.poll();// retira o primeiro da fila
			if (lastElement.getLeftChild() != null)
				deck.addLast(lastElement.getLeftChild());
			if (lastElement.getRightChild() != null)
				deck.addLast(lastElement.getRightChild());

			System.out.println(lastElement.getValue());

		}
	}

	public void print() {
		this.root.print();
	}
}
