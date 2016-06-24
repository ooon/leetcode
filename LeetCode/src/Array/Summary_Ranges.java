package Array;
import java.util.*;
public class Summary_Ranges {
	public static void main(String[] args) {
		Summary_Ranges sr = new Summary_Ranges();
		int [] nums ={1};
		System.out.println(sr.summaryRanges(nums));
	}
	
	public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<String>();
        if(nums.length == 0 ) return res;
        int left = 0,right = 0;
        while(right < nums.length){
        	right ++; // 拉开 right 与 left 
            while(right < nums.length && nums[right-1] == nums[right]-1) ++ right;
            res.add(tostr(nums[left],nums[right-1]));
            left = right;
        }
        return res;
    }
    public String tostr(int left,int right){
        if(right == left  ) return left+"";
        return left+"->"+right;
    }
}
