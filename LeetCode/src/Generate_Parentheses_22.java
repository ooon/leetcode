import java.util.*;

public class Generate_Parentheses_22 {
	public static void main(String[] args) {
		Generate_Parentheses_22 p = new Generate_Parentheses_22();
		System.out.println(p.generateParenthesis(2));
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		String temp = "";
		generate(n, n, temp, result);
		return result;
	}

	public void generate(int leftNum, int rightNum, String s,
			List<String> result) {
		if (leftNum == 0 && rightNum == 0) {
			result.add(s);
		}
		if (leftNum > 0) {
			generate(leftNum - 1, rightNum, s + '(', result);
		}
		if (rightNum > 0 && leftNum < rightNum) {
			generate(leftNum, rightNum - 1, s + ')', result);
		}
	}
}