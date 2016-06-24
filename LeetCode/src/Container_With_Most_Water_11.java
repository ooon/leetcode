import java.util.Arrays;

/**
 * 暴力算法是[双重循环]
 *  对于 1.。。n
 *  找到  1->n,2->n ... n-1->n中每一组循环最大的
 *  
 * 两个木板的水量取决于短的木板，
 * 
 * 所以对于短木板，另外的木板无论多长也没用，所以可以忽略比较，即哪边短哪边向中间靠拢
 * 有两个指针i和j分别指向头和尾， 如果a[i]<a[j], 则i++,否则j--:
	证明：
	对任意ｋ<j：
	都有(k-i)*min(a[k],a[i]) < (j-i)min(a[j],a[i]) = (j-i)a[i]
	因为：
	(k-i) < (j-i)
	min(a[k],a[i]) < a[i] < min(a[j],a[i])
 * @author Administrator
 *
 */
public class Container_With_Most_Water_11 {
	
	public static void main(String[] args) {
		int a[] ={1,2,4,3};
		System.out.println(maxArea(a));
	}
	//
	 public static int maxArea(int[] height) {
		if(height.length < 2) return 0;
		int left = 0;
		int right = height.length-1;
		int tempcap = 0;
		int capcity = 0;
		while(left < right){
			//用小的那边*高度
			tempcap = (height[left] >= height[right] ? height[right] : height[left]);
			tempcap *= ( right-left );
			capcity  =  tempcap > capcity ?	tempcap : capcity;
			
			if(height[left] > height[right]) {
				left++;
			}else{
				right--;
			}
		}
		return capcity;
	 }
	
//****quick sort 1********
//	 public static void quicksort(int[] height,int l, int r ){
//		 if(l<r){
//			 int i = partion(height,l,r);
//			 quicksort(height,l,i-1);
//			 quicksort(height,i+1,r);
//		 }
//		 
//	 }
//	 public static int partion(int[] height, int l, int r){
//		 int i = l ; 
//		 int j = r;
//		 int temp = height[i];
//		 while(i<j){
//			while(i<j && height[j] > temp) j--;
//			
//			if(i<j) height[i++] = height[j];
//			
//			while(i<j && height[i] < temp) i++;
//			
//			if(i<j) height[j--] = height[i];
//			
//			height[i] = temp;
//		 }
//		 return i;
//	 }
	//****quick sort 2*****把法1写到一起
//	 public static void quicksort(int[] height,int l, int r ){
//	 if(l<r){
//		 int i = l ; 
//		 int j = r;
//		 int temp = height[i];
//		 while(i<j){
//			while(i<j && height[j] > temp) j--;
//			
//			if(i<j) height[i++] = height[j];
//			
//			while(i<j && height[i] < temp) i++;
//			
//			if(i<j) height[j--] = height[i];
//			
//			height[i] = temp;
//		 }
//		 quicksort(height,l,i-1);
//		 quicksort(height,i+1,r);
//	 }
//	 
}	 

