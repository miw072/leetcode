//leetcode 2nd 2015/2/9
//Mingxuan Wang
//searchMatrix

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
		int col = matrix[0].length;
		int start = 0;
		int end = row * col - 1;
		
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			int num = matrix[mid / col][mid % col];
			if (num == target){
				return true;
			}else if (num > target){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		if (matrix[start/col][start%col] == target){
			return true;
		}
		if (matrix[end/col][end%col] == target){
			return true;
		}
		return false;
    }
}