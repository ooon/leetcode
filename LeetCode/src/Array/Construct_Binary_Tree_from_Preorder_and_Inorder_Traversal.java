package Array;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public static void main(String[] args) {
		Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal c = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		int a[] = {1,2};
		int b[] = {2,1};
		c.buildTree(a,b);
	}
	
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        //preorder 先序
	        //inorder 中序
	       //*********直接切分数组的方式,可通过********
	        // if(preorder.length ==0) return null;
	        // int len = preorder.length;
	        // TreeNode root = createNode(preorder[0]);
	        // int index = find(preorder[0],inorder);
	        // int left_pre[] = new int[index];
	        // int right_pre[] = new int[preorder.length-index-1];
	        // System.arraycopy(preorder,1,left_pre,0,left_pre.length);
	        // System.arraycopy(preorder,1+left_pre.length,right_pre,0,right_pre.length);
	        // int left_in[] = new int[index];
	        // int right_in[] = new int[preorder.length-index-1];
	        // System.arraycopy(inorder,0,left_in,0,left_in.length);
	        // System.arraycopy(inorder,left_in.length+1,right_in,0,right_in.length);
	        // root.left = buildTree(left_pre,left_in);
	        // root.right = buildTree(right_pre,right_in);
	        // return root;
	       //***************************************
	        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	    }
	    //********************暂时没有调通*****************    
	    public TreeNode build(int[] preorder, int pre_left, int pre_right,int[] inorder, int in_left,int in_right){
	        if(in_left > in_right || pre_left >= preorder.length ) return null;
	        TreeNode root = createNode(preorder[pre_left]);
	        int index = 0;
	        for(int i = in_left ; i <= in_right ; i ++){
	            if(preorder[pre_left] == inorder[i]){
	                index = i;
	                break;
	            }
	        }
	        
	        //注意 pre_left+1 可能会造成越界
	        //                                0         1                           1    
	        root.left  = build(preorder, pre_left+1, index , inorder, in_left , index-1);
	        root.right = build(preorder, pre_left+(index-in_left)+1, pre_right, inorder, index+1, in_right);
	        return root;
	    }
	    
	    public TreeNode createNode(int val){
	        TreeNode res = new TreeNode(val);
	        res.left = res.right = null;
	        return res; 
	    }
	    
	    //**********************Disscuss里的Hot！*******************************

	// }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      public String toString(){
	    	  return this.val+"";
	      }
	  }
