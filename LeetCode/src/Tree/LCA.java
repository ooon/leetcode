package Tree;
import java.util.*;
public class LCA {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		TreeNode p  = root.left.left.left;
		TreeNode q = root.left.right;
		LCA l = new LCA();
		l.lowestCommonAncestor(root,p,q);
	}
	 	List<TreeNode> p_path = null;
	    List<TreeNode> q_path = null;
	    List<TreeNode> path   = null;
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        p_path = new LinkedList<TreeNode>();
	        q_path = new LinkedList<TreeNode>();
	        path   = new LinkedList<TreeNode>();
	        dfs(root,p,q,path,p_path,q_path);
	        TreeNode res = root;
	        int idx = 0 ;
	        //找到两个列表中最后一个相同元素的方法
	        while(idx < p_path.size() && idx < q_path.size()){
	            if(p_path.get(idx) != q_path.get(idx)) break;
	            else res = q_path.get(idx++); 
	        }
	        return res;
	    }
	    
	    public void dfs(TreeNode root, TreeNode p, TreeNode q, 
	        List<TreeNode> path, List<TreeNode> p_path, List<TreeNode> q_path ){
	        //注意找某节点路径的方法，什么时候回溯，什么时候更改
	        if(root != null){
	            path.add(root);
	            if(root == p) p_path.addAll(path);
	            if(root == q) q_path.addAll(path);
	            if(p_path .size() > 0 && q_path .size() > 0) return ;
	            dfs(root.left , p, q, path, q_path, q_path);
	            dfs(root.right, p, q, path, q_path, q_path);
	            path.remove(path.size()-1);
	        }    
	    }
}
