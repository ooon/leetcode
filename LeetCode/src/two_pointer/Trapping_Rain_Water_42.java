package two_pointer;

public class Trapping_Rain_Water_42 {
	public static void main(String[] args) {
		Trapping_Rain_Water_42 trw = new Trapping_Rain_Water_42();
		int a[] = {2,0,2};
		System.out.println(trw.trap(a));
	}
	
	 public int trap(int[] height) {
		   if(height.length <2) return 0;
	        int maxidx = 0 ;//最高墙的下标
	        int max = 0;// 最高墙的高度
	        int n = height.length;//数组长度
	        int capacity = 0;
	        int base = height[0]; //当前水平面，并且始终保持为max以左最高的
	        for(int i = 0 ; i < n ; ++i){
	            if(height[i] > max ) {
	                max = height[i];
	                maxidx = i;
	            }    
	        }
	        for(int i = 0 ; i < maxidx ; ++i){
	            if(base < height[i]) base = height[i];
	            else capacity += base - height[i];
	        }
            base = height[n-1];//当前水平面，并且始终保持为max以右最高的
	        for(int j = n-1; j > maxidx; --j){
	            if(base < height[j]) base = height[j];
	            else capacity += base - height[j];
	        }
	        return capacity;
	    }
}
