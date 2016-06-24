package Array;

public class Median_of_Two_Sorted_Arrays_4 {
	public static void main(String[] args) {
		Median_of_Two_Sorted_Arrays_4 sts =  new Median_of_Two_Sorted_Arrays_4(); 
		int A[] = {2,3};
		int B[] = {1};
		System.out.println(sts.findMedianSortedArrays(A,B));
	}
	
	 public double findMedianSortedArrays(int[] A, int[] B) {
	        int m = A.length;
	        int n = B.length;
	        int max_left  = 0;
	        int min_right = 0;
	        // 如果A长，则用A代表B，即转换后A的长度不能超过B。
	        if(m>n){
	            int C[] = A;
	            A = B; B = C;
	            int t = m;
	            m = n; n = t;
	        }
	        if( n == 0 ) return 0f;
	        int imin = 0 , imax = m, half_len = (m+n+1)/2;
	        while(imin < imax){
	            int i = (imin + imax) / 2;
	            int j = half_len - i;// 确保 i+j 的长度是两个数组长度和的一半
	            //分三种情况找到租后的解：
	            if( j > 0 && i < m && B[j-1] > A[i]) imin = i + 1;
	            else if ( i > 0 && j < n && A[i-1] > B[j] ) imax  = i -1;
	            else{
	                if( i == 0 ) max_left = B[j-1];
	                else if (j == 0) max_left = A[i-1];
	                else max_left = Math.max(A[i-1],B[j-1]);
	                
	                if ((m+n)%2 ==0) return max_left;
	                
	                if(i == m) min_right =B[j];
	                else if(j==n) min_right=A[i];
	                else min_right = Math.min(A[i],B[i]);
	            }
	        }    
	        return (max_left + min_right) / 2.0;
	    }
}
