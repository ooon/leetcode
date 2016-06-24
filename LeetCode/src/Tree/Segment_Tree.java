package Tree;

public class Segment_Tree {
	
	Node root = null;
	class Node{
		//区间
		int start;
		int end;
		int sum; //区间的和
		Node left;
		Node right;
		Node(int start ,int end){
			this.start =start;
			this.end = end;
		}
	}
	Segment_Tree(int[] nums){
		root = buildTree(nums,0,nums.length-1);
	}
	//build tree;
	public Node buildTree(int[] nums ,int start, int end ){
		if(start > end) 
			return null;
		Node p = new Node(start,end);
		if(start == end){
			p.sum = nums[start];
		}else{
			int mid = start +(end -start)/2;
			p.left  = buildTree(nums,start,mid);
			p.right = buildTree(nums,mid+1,end);
			p.sum   = p.left.sum + p.right.sum;
		}
		return p;
	}
	void update( int i ,int val){
		update(root,i,val);
	}
	void update(Node root, int pos ,int val){
		if(root.start ==root.end)
			root.sum = val;
		else{
			int mid = root.start + (root.end -root.start)/2;
			if(pos <= mid){
				update(root.left ,pos, val);
			}else{
				update(root.right,pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}
	public int sumRange(int i,int j){
		return sumRange(root,i,j);
	}
	public int sumRange(Node root,int start,int end){
		if(root.start == start && root.end == end){
			return root.sum;
		}else{
			int mid = (root.start +root.end ) / 2;
			if(end <= mid){
				//落在左边
				sumRange(root.left,start,end);
			}else if(start > mid){
				// 落在右边
				sumRange(root.right,start,end);
			}else{
				//左右都有
				return sumRange(root.left,start,mid)
						+ sumRange(root.right,mid+1,end);
			}
		}
		return 0;
	}
	static int[] nums = {1,2,3,4,5,6};
	public static void main(String[] args) {
//		Segment_Tree st = new Segment_Tree();
//		st.build(0, nums.length-1);
	}
}
