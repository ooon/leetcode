package Tree;

import java.util.LinkedList;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	public static void main(String[] args) {
		Populating_Next_Right_Pointers_in_Each_Node_II p =new Populating_Next_Right_Pointers_in_Each_Node_II();
		
		Node root = new Node(1);
		root.left  = new Node(8);
		root.right = new Node(3);
		root.left.left  = new Node(4);
		root.left.right  = new Node(11);
		root.right.right  = new Node(5);
		p.connect(root);
	}
	  public void connect(Node root) {
	       if(root == null) return ;
	       //十分万能的，当队列或者栈都可以用的 LinkedList。
	       LinkedList<Node> queue = new LinkedList<Node>();
	       queue.add(root);
	       int parent = 1;
	       int children = 0;
	       while(!queue.isEmpty()){
	    		System.out.print(queue.peek() +" ");
	    		Node cur = queue.removeFirst();
	    		--parent; 
	    		if(cur.left  != null) {queue.addLast(cur.left ); ++children;}
	    	    if(cur.right != null) {queue.addLast(cur.right); ++children;}
	    	    if(parent == 0) {System.out.println(); parent = children; children = 0;}
	       }
	    }
}
 class Node {
     int val;
     Node left, right;
     Node(int x) { val = x; }
     public String toString(){
    	 return val+"";
     }
 }
