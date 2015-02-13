//leetcode 2nd 2015/2/9
//Mingxuan Wang
//setZeroes

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}
		
		boolean row0 = false;
		boolean col0 = false;
		
		for (int i = 0; i < matrix.length; i++){
			if (matrix[i][0] == 0){
				col0 = true;
				break;
			}
		}
		
		for (int i = 0; i < matrix[0].length; i++){
			if (matrix[0][i] == 0){
				row0 = true;
				break;
			}
		}
		
		for (int i = 1; i < matrix.length; i++){
			for (int j = 1; j < matrix[0].length; j++){
				if (matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; i++){
			for (int j = 1; j < matrix[0].length; j++){
				if (matrix[0][j] == 0 || matrix[i][0] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		
		if (row0){
			for (int i = 0; i < matrix[0].length; i++){
				matrix[0][i] = 0;
			}
		}
		if (col0){
			for (int i = 0; i < matrix.length; i++){
				matrix[i][0] = 0;
			}
		}
    }
}