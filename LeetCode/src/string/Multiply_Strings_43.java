package string;

public class Multiply_Strings_43 {
	public static void main(String[] args) {
		Multiply_Strings_43 ms = new Multiply_Strings_43();
		ms.multiply("1212121223"
				,"451212121");
	}
	/**
	 * 这个代码简直是太优雅了，佩服
	 * 依靠i与j的位置关系进行运算，很巧妙
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
	    int m = num1.length(), n = num2.length();
	    
	    int[] pos = new int[m + n];
	    
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    System.out.println(sb.toString());
	    return sb.length() == 0 ? "0" : sb.toString();
	}
}


