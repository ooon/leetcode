package stack;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
	public static void main(String[] args) {
		int a[] ={2,1,5,6,2,3};
		System.out.println(largestRectangleArea(a));
	}
	 public static  int largestRectangleArea(int[] height) {
	        int len = height.length;
	        Stack<Integer> s = new Stack<Integer>();
	        int maxArea = 0;
	        for(int i = 0; i <= len; i++){
	        	//把最后一个元素当做0处理。这样省去复制数组
	            int h = (i == len ? 0 : height[i]);
	            if(s.isEmpty() || h >= height[s.peek()]){
	                s.push(i);
	            }else{
	                int tp = s.pop();
	                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
	                i--;
	            }
	        }
	        return maxArea;
	    }
}
