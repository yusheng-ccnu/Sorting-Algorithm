package niuke;

import java.util.ArrayList;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1234, 5678, 9 10 11 12, 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */
public class PrintMatrix {

	public static void main(String[] args) {
		PrintMatrix p =new PrintMatrix();
		int[]s[]  = new int[10][10];
		int ss = 1;
//		int [][] crr = {
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16}
//		};
		int [][] crr = {
				{1,2},
				{3,4},
				{5,6},
				{7,8}
		};
		p.ArraytoString(crr);
		System.out.println(p.printMatrix(crr));
		
	}
	
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int col = matrix.length;
		int row = matrix[0].length;
		int mark = 0;
		if(col > row) {
			mark = 1;
		}
		while (true) {
			for (int i = 0; i < matrix[0].length; i++) {
				result.add(matrix[0][i]);
			}
			if(result.size() >= col*row) {
				return result;
			}
			
			if(mark % 2 == 0 ) {
				matrix = reverse(matrix, matrix.length, matrix[0].length-1);
				mark++;
			}
			else {
				matrix = reverse(matrix, matrix.length-1, matrix[0].length);
				mark++;
			}
		}
	}
	
	public int[][] reverse(int [][] matrix,int col,int row){
		if(matrix.length == 0) {
			return null;
		}
		int [][] crr = new int[col][row];
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				crr[i][j] = matrix[j+1][col-i-1];
			}
		}
		return crr;
	}
	
	public void ArraytoString(int[][] a) {
		StringBuffer sb = new StringBuffer();
		int col = a.length;
	    int row = a[0].length;
		for(int i=1; i<col; i++) {
			for(int j=0; j<row; j++) {
				sb.append(" "+a[i][j]);
				//System.out.print(a[i][j]);
			}
		}
		System.out.println(sb.toString());
	}

}
