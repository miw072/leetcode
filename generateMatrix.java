//leetcode 2nd 2015/2/7
//Mingxuan Wang
//generateMatrix

public class Solution {
    public int[][] generateMatrix(int n) {
		if (n < 0){
			return null;
		}
		
		int[][] result = new int [n][n];
		int row = 0;
		int col = 0;
		int num = 1;
		
		while (n > 0){
			if (n == 1){
				result[row][col] = num++;
			}
			
			for (int i = 0; i < n - 1; i++){
				result[row][col + i] = num++;
			}
			for (int i = 0; i < n - 1; i++){
				result[row + i][col + n - 1] = num++;
			}
			for (int i = 0; i < n - 1; i++){
				result[row + n - 1][col + n - 1 - i] = num++;
			}
			for (int i = 0; i < n - 1; i++){
				result[row + n - 1 - i][col] = num++;
			}
			col++;
			row++;
			n = n - 2;
		}
		return result;
    }
}