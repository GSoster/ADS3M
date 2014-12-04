import br.com.guilhermesosters.model.Node;
import br.com.guilhermesosters.model.Tree;


public class main {

	public static void main(String[] args) {
		Tree t = new Tree();
		Node n = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		t.insert(n);
		t.print();
		System.out.println();
		t.insert(n2);
		
		t.print();		
		t.insert(n3);		
		t.insert(n4);
		t.insert(n5);
		System.out.println();
		t.print();
		System.out.println();
		t.posOrderAdjustment();
		t.print();
		//System.out.println(t.getRoot().getValue());
	}
	
}
