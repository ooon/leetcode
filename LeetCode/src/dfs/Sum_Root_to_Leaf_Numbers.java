package dfs;

public class Sum_Root_to_Leaf_Numbers {

	public int dfs(TreeNode root) {
		int depth = 0;
		if (root != null) {
			int ldep = dfs(root.left);
			int rdep = dfs(root.right);
			depth = ldep >= rdep ? ldep + 1 : rdep + 1;
		}
		return depth;
	}
}
 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

