//设计一个算法对m*n的矩阵进行搜索，这个矩阵有如下属性：
//每行从左到右排序
//每行第一个大于上一行最后一个
boolean searchMatrix(int[][] matrix, int target){
	int m = matrix.length;
	int n = matrix[0].length;
	int low = 0;
	int high = m*n-1;
	while(low <= high){
		int mid = (low+high)/2;
		if (matrix[mid/n][mid%n] == target){
			return true;
		}else if(matrix[mid/n][mid%n] < target){
			low = mid+1;
		}else{
			high = mid-1;
		}
	}
	return false;
}