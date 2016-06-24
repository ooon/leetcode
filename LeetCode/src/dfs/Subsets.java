package dfs;
import  java.util.*;
public class Subsets {
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int nums[] = {1};
		System.out.println(s.subsets(nums));
	}
	 public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> tmp = new ArrayList<Integer>();
	        res.add(tmp);
	        Arrays.sort(nums);
	        for(int k = 0 ; k < nums.length ; k ++){
	            dfs(nums,k+1,0,res,tmp);   
	        }
	        return res;
	        
	    }
	    public void dfs(int[] nums, int k ,int begin, List<List<Integer>> res ,  List<Integer> tmp){
	        if(tmp.size() == k ){
	            res.add(new ArrayList<Integer>(tmp));
	           
	        }
	        for(int i = begin ; i < nums.length; i++){
	            tmp.add(nums[i]);
	            dfs(nums, k, i+1 , res,tmp);
	            tmp.remove(tmp.size()-1);
	        }
	    }
}
