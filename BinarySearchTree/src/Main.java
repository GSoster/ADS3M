import br.com.guilhermesoster.model.*;

public class Main {
	public static void main(String[] args) {

		Tree tree = new Tree();
		tree.insert(new Node(1));// root
		tree.insert(new Node(2));// leftChild
		tree.insert(new Node(3));// rightChild
		// saida do print tem de ser: 123 -> (1(2(3)))
		tree.print();
		System.out.println();
		tree = null;

		tree = new Tree();
		tree.insert(new Node(2));// root
		tree.insert(new Node(1));// leftChild
		tree.insert(new Node(3));// rightChild
		// saida do print tem de ser: 213 -> (2(1)(3))
		tree.print();
		System.out.println();

		//busca 'em ordem' --> leftChild, this, rightChild
		tree.inOrderSearch();
		System.out.println();
		tree = null;
		tree = new Tree();
		tree.insert(new Node(2));//root
		tree.insert(new Node(5));//rightChild
		tree.insert(new Node(1));//leftChildChild
		tree.insert(new Node(6));//rightChild do rightChild
		tree.insert(new Node(4));//leftChild do rightChild
		tree.inOrderSearch();
		
		System.out.println();
		tree.stackSearch();
		System.out.println();
		tree.deckSearch();
		
		
	}
}
