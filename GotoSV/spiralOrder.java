//给定一个m*n的矩阵，按螺旋顺序返回所有元素
ArrayList<Integer> spiralOrder(int[][] matrix){
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (matrix.length == 0){
		return result;
	}
	int beginX = 0, endX = matrix[0].length-1;
	int beginY = 0, endY = matrix.length - 1;
	
	while (true){
		//外围从左到右
		for (int i = beginX; i <= endX; i++){
			result.add(matrix[beginY][i]);
		}
		if (++beginY > endY){
			break;
		}
		//从上到下
		for (int i = beginY; i <= endY; i++){
			result.add(matrix[i][endY]);
		}
		if (beginX > --endX){
			break;
		}
		//从右到左
		for (int i = endX; i >= beginX; i--){
			result.add(matrix[endY][i]);
		}
		if (beginY > --endY){
			break;
		}
		//从下到上
		for (int i = endY; i >= beginY; i--){
			result.add(matrix[i][beginX]);
		}
		if (++beginX > endX){
			break;
		}
	}
	return result;
}