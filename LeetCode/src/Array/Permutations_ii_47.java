package Array;
import java.util.*;

public class Permutations_ii_47 {
	public static void main(String[] args) {
		int[] a = {2,2,1,1};
		Permutations_ii_47 p = new Permutations_ii_47();
		
		System.out.println(p.permuteUnique(a));
	}
	 public List<List<Integer>> permuteUnique(int[] nums) {
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   Arrays.sort(nums);
		   find(nums,0,result);
		   return result;
		 }
	    public void find(int[] nums,int begin,List<List<Integer>> res){
	        if(begin == nums.length){
	            List<Integer> tmp = new ArrayList<Integer>(); 
	            for(int i = 0 ; i < nums.length ; i ++){
	                tmp.add(nums[i]);
	            }
	            if(!res.contains(tmp))
	            	res.add(tmp);
	        }
	        for(int i = begin ; i < nums.length ; i ++ ){
	            if(i > begin && nums[i] == nums[begin]) continue;
	            swap(nums,begin,i);
	            find(nums,begin+1,res);
	            swap(nums,begin,i);
	        }
	    }
	    public void swap(int nums[], int i,int j){
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	    }
}	
