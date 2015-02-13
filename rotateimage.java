//leetcode 2nd 2015/2/4
//Mingxuan Wang
//rotateimage

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}
		
		int len = matrix.length;
		for (int layer = 0; layer < len / 2; layer++){
			int first = layer;
			int last = len - layer - 1;
			
			for (int i = 0; i < last; i++){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
    }
}