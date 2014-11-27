import br.com.guilhermesosters.model.Node;
import br.com.guilhermesosters.model.Tree;


public class main {

	public static void main(String[] args) {
		Tree t = new Tree();
		Node n = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		t.insert(n);
		t.print();
		t.insert(n2);
		t.print();
		t.insert(n3);
	
		t.print();
		//System.out.println(t.getRoot().getValue());
	}
	
}
