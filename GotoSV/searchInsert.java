int searchInsert(int[] A, int target){
	int low = 0, high = A.length-1, mid;
	while(low <= high){
		mid = (low+high)/2;
		if(A[mid] == target){
			return mid;
		}else if(A[mid] > target){
			high = mid-1;
		}else{
			low = mid+1;
		}
	}
	//返回第一个大于目标值的元素下标
	return low;
}