import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;


public class Combination_Sum_39 {
	public static void main(String[] args) {
		int a[] ={2,3,6,7};
		System.out.println(new Combination_Sum_39().combinationSum(a,7));
	}
//	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
//	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//	 
//	    if(candidates == null || candidates.length == 0) return result;
//	 
//	    ArrayList<Integer> current = new ArrayList<Integer>();
//	    Arrays.sort(candidates);
//	 
//	    combinationSum(candidates, target, 0, current, result);
//	 
//	    return result;
//	}
//	 /**
//	  * 
//	  * @param candidates
//	  * @param target 递归过程当中需要找的数字是什么、、？
//	  * @param j
//	  * @param curr
//	  * @param result
//	  */
//	public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
//	   if(target == 0){
//	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
//	       result.add(temp);
//	       return;
//	   }
//	 
//	   for(int i=j; i<candidates.length; i++){
//	       if(target < candidates[i]) 
//	            return;
//	 
//	       curr.add(candidates[i]);
//	       combinationSum(candidates, target - candidates[i], i, curr, result);
//	       curr.remove(curr.size()-1); 
//	   }
//	}
	/**
	 * 	
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates.length ==0 ) return result;
		//记住对数组排序的方法。
		Arrays.sort(candidates);
		List<Integer> cur = new ArrayList<Integer>();
		dfs(candidates,target,0,cur,result);
		return result;
	}
	public void dfs(int[] candidates, int target ,int j, List<Integer> cur, List<List<Integer>> result){
		if(target == 0){//递归结束的条件
			//注意此处的序列，要添加一个新的引用过来
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		//j可以理解为开始遍历的下标，不会导致从头开始遍历
		for(int i = j ; i < candidates.length ; i ++){
			if(target < candidates[i]) return;
			cur.add(candidates[i]);
			dfs(candidates,target - candidates[i],i,cur,result);
			cur.remove(cur.size()-1);//移除最后一个不满足的元素
		}
	}
}
