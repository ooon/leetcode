import java.util.Stack;


public class Binary_Search_Tree_Iterator_173 {
	  	int result ;
		Stack<TreeNode> path = new Stack<TreeNode>();
	   	public  Binary_Search_Tree_Iterator_173(TreeNode root) {
	   		while(root !=null){
	   			path.push(root);
	   			root = root.left;
	   		}
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	
	    	if(!path.isEmpty()){
	    		result = path.peek().val;
	    		TreeNode cur = path.pop().right;//取得当前栈顶元素的右节点
	    		if(cur!= null){
	    			while( cur.left !=null){
	    			    path.push(cur);
	    				cur = cur.left;
	    			}
	    		}
	    		return true;
	    	}
	        return false;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return result;
	    }
		public static void main(String[] args) {
			TreeNode root = new TreeNode(0);
			Binary_Search_Tree_Iterator_173 bst = new Binary_Search_Tree_Iterator_173(root);
			while(bst.hasNext()){
				System.out.println(bst.next());
			}
			
		}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
