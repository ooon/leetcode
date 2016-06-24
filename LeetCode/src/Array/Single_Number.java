package Array;

public class Single_Number {
	public static void main(String[] args) {

	       int a = 1;
	           for(int j = 0 ; j < 10 ; j ++){
	              System.out.println( a << j); ;
	           }
	       
	}

	public static int singleNumber(int[] A) {
		
		int ones = 0, twos = 0, threes = 0;

		for (int i = 0; i < A.length; i++) {
			twos |= ones & A[i];
			ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
			// 对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;

		}
		return ones;
	}
}
