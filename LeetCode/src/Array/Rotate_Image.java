package Array;

import java.util.Arrays;

public class Rotate_Image {
	public static void main(String[] args) {
		Rotate_Image ri = new Rotate_Image();

	     int count = 1;
	     int N = 3;
	     int matrix[][] = new int[N][N+1];
	     System.out.println("初始矩阵 ： ");
		 for(int i = 0 ; i < N ; i ++){
	         for(int j = 0 ; j < N+1 ; j ++){
	        	matrix[i][j] = count++;
	         }
	         System.out.println(Arrays.toString(matrix[i]));
	     }
		 ri.transpose(matrix);
	}
	//非原地旋转
	 public void rotate_f(int[][] matrix) {
	     int M = matrix.length;
	     int N = matrix[0].length;
	     int[][] res = new int[N][M];
	     for(int i = 0 ; i < M ; i ++){
	         for(int j = 0 ; j < N ; j ++){
	        	 res[j][M-1-i]= matrix[i][j]; 
	         }
	     }
	   	 for(int i = 0 ; i < N ; i ++){
        	 System.out.println(Arrays.toString(res[i]));
	   	 }
	}
	 //方阵转置操作
	 public void transpose (int[][] matrix) {
	     int M = matrix.length;//3
	     int N = matrix[0].length;//4

	     int[][] res = new int[N][M];
	     for(int i = 0 ; i < N ; i ++){
	         for(int j = 0  ; j < M ; j ++){
	        	 res[i][j]= matrix[j][i];
	         }
	     }
	     System.out.println("transpose :");
	   	 for(int i = 0 ; i < N ; i ++){
        	 System.out.println(Arrays.toString(res[i]));
	   	 }
	}
	 public void rotate(int[][] matrix) {
		 int N = matrix.length;
		 System.out.println();
	        for(int i = 0 ; i < N ; i ++){
	            for(int j = i ; j < N ; j ++){
	                int tmp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = tmp;
	            }
	            System.out.println(Arrays.toString(matrix[i]));
	        }

			 System.out.println();
	         for(int i = 0 ; i < N ; i ++){
	            for(int j = 0 ; j < N/2 ; j ++){
	                int tmp = matrix[i][j];
	                matrix[i][j] = matrix[i][N-j-1];
	                matrix[i][N-j-1] = tmp;
	            }
	            System.out.println(Arrays.toString(matrix[i]));
	        }
		 
	}
}
