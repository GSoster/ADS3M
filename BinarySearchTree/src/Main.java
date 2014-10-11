import br.com.guilhermesoster.model.*;

public class Main {
	public static void main(String[] args){
		
		
		Tree tree = new Tree();
				
		tree.insert(new Node(1));		
		tree.insert(new Node(2));		
		tree.insert(new Node(3));		
		
		//123 -> (1(2(3)))
		tree.print();				
		
		System.out.println();
		
		Tree tree2 = new Tree();
		tree2.insert(new Node(2));
		tree2.insert(new Node(1));						
		tree2.insert(new Node(3));
		//213 -> (2(1)(3))
		tree2.print();
		
		// tree.preOrderSearch();
		
	}
}
