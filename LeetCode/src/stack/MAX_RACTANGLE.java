package stack;

import java.util.Arrays;
import java.util.Stack;

public class MAX_RACTANGLE {
	public static void main(String[] args) {
		char matrix [][] = {{'1'}};
		MAX_RACTANGLE mr = new MAX_RACTANGLE();
		System.out.println(mr.maximalRectangle(matrix));;
	}
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix[0].length ==0 || matrix.length ==0)
			return 0;
		int area = 0;
		int col_num = matrix[0].length;
		int row_num  = matrix.length;
		//对每一行构建一个 histogram，然后用波峰图来找到面积
		int[] h = new int[col_num+1];
		for(int row = 0; row < row_num ; row ++){
			Stack<Integer> s = new Stack<Integer>();
			for(int col = 0 ; col < col_num+1 ; col++){
				//对 histogram 进行赋值操作
				if(col < col_num && matrix[row][col] == '1') h[col] += 1;
				else h[col] = 0;
				//接下来类似于 84 的处理，构建波峰图
				if(s.isEmpty() || h[s.peek()] <= h[col]){
					s.push(col);
				}else{
					  while(!s.isEmpty() && h[s.peek()] >= h[col]){
					        int height = h[s.pop()];
						    int width  = s.isEmpty() ? col : col - s.peek() - 1;
						    area = area > height * width ? area : height * width;
					    } 
					    s.push(col);
				}
			}

			System.out.println(Arrays.toString(h));
			s.clear();
		}
		
		return area;
	}
}
