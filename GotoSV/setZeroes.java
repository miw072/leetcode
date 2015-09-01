//给定一个二维m*n矩阵，如果某个元素为0，那么将其所在行和列的所有元素设为0。
void setZeroes(int[][] matrix){
	int m = matrix.length;
	if (m == 0){
		return;
	}
	int n = matrix[0].length;
	int x = -1, y = -1;
	for (int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(matrix[i][j] == 0){
				if (x == -1 && y == -1){
					//第一个0元素
					x = i;
					y = j;
				}else{
					matrix[x][j] = 0;
					matrix[i][y] = 0;
				}
			}
		}
	}
	
	if (x == -1 || y == -1){
		return;
	}
	for (int i = 0; i < m; i++){
		for (int j = 0; j < m; j++){
			if(matrix[x][j] == 0 || matrix[i][y] == 0){
				matrix[i][j] = 0;
			}
		}
	}
}