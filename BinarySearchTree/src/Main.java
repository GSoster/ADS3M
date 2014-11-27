import br.com.guilhermesoster.model.*;

public class Main {
	public static void main(String[] args) {

		// teste1();

		// testeRotacaoEsquerdaEDireita();

		Tree tree = new Tree();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		tree.insert(n1);
		tree.insert(n2);
		tree.insert(n3);
		tree.insert(n4);
		tree.insert(n5);
		tree.insert(n6);
		tree.insert(n7);
		tree.insert(n8);
		tree.print();
		
		
		/*Tree tree = new Tree();
		Node root = new Node(1);
		tree.insert(root);
		tree.insert(new Node(2));
		Node n = new Node(3);
		tree.insert(n);
		tree.insert(new Node(4));
		tree.insert(new Node(5));
		System.out.println(n.getH());
		System.out.println(root.getH());
		*/
		/*tree.deckSearch();
		tree.leftRotation(n);
		tree.deckSearch();*/
		tree.print();

	}

	private static void testeRotacaoEsquerdaEDireita() {
		Tree tree = new Tree();
		Node root = new Node(5);
		tree.insert(root);
		tree.insert(new Node(4));
		Node n = new Node(7);
		tree.insert(n);
		tree.insert(new Node(6));
		tree.insert(new Node(8));
		tree.insert(new Node(9));
		tree.deckSearch();
		tree.leftRotation(root);
		// tree.deckSearch(n);
		tree.deckSearch();
		tree.rightRotation(n);
		tree.deckSearch();

	}

	private static void teste1() {
		Tree tree = new Tree();
		tree.insert(new Node(1));// root
		tree.insert(new Node(2));// rightChild
		tree.insert(new Node(3));// rightChild do 2
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

		// busca 'em ordem' --> leftChild, this, rightChild
		tree.inOrderSearch();
		System.out.println();
		tree = null;
		tree = new Tree();
		tree.insert(new Node(2));// root
		tree.insert(new Node(5));// rightChild
		tree.insert(new Node(1));// leftChildChild
		tree.insert(new Node(6));// rightChild do rightChild
		tree.insert(new Node(4));// leftChild do rightChild
		tree.inOrderSearch();

		System.out.println();
		tree.stackSearch();
		System.out.println();
		tree.deckSearch();
	}

}
