//leetcode 2nd 2015/2/5
//Mingxuan Wang
//spiralOrder

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return result;
		}
		
		rec(matrix, 0, 0, matrix.length, matrix[0].length, result);
		return result;
    }
	
	private void rec(int[][] matrix, int x, int y, int row, int col, List<Integer> result){
		if (row <= 0 || col <= 0){
			return;
		}
		
		for (int i = 0; i < col; i++){
			result.add(matrix[x][y + i]);
		}
		
		for (int i = 1; i < row - 1; i++){
			result.add(matrix[x + i][y + col - 1]);
		}
		
		//bug here: need to check if it is the last row or col
		if (row > 1){
			for (int i = col - 1; i >= 0; i--){
				result.add(matrix[x + row - 1][y + i]);
			}
		}
		
		if (col > 1){
			for (int i = row - 2; i > 0; i--){
				result.add(matrix[x + i][y]);
			}
		}
		
		rec(matrix, x + 1, y + 1, row - 2, col - 2, result);
	}
}